package one.estate.room.flat;

import one.estate.room.Area;
import one.estate.room.Room;
import one.person.Osoba;
import one.util.Logger;
import one.util.TimeUtil;
import one.util.Validator;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Optional;

public class Mieszkanie implements Room {

    private final Area area;
    private final LinkedList<Osoba> people;
    private final LocalDate leaseStartDate;
    private LocalDate leaseEndDate;
    private final int id = Room.getNextId();
    private boolean expired;
    private Area usedArea;
    private boolean cleared;

    public Mieszkanie(final Area area, final LinkedList<Osoba> people, final LocalDate leaseStartDate, final LocalDate leaseEndDate) {
        this.area = area;
        this.people = people;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        if (!rooms.containsKey(id)) {
            rooms.put(id, this);
        }
        setExpired(false);
        setUsedArea(new Area(0));

        Logger.DEBUG.log("Initialized " + this);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Area getArea() {
        return area;
    }

    @Override
    public LinkedList<Osoba> getPeople() {
        return people;
    }

    @Override
    public Osoba getTenant() {
        return (Osoba) people.toArray()[0];
    }

    @Override
    public void setTenant(final Osoba tenant) {
        people.add(0, Validator.validateTenant(tenant));
        Logger.LEASE.log(tenant.getFullName() + " is now renting " + this + ".");
    }

    @Override
    public void addPerson(final Osoba osoba) {
        people.add(osoba);
    }

    @Override
    public void removePerson(final Osoba osoba) {
        people.remove(osoba);
    }

    @Override
    public LocalDate getLeaseStartDate() {
        return leaseStartDate;
    }

    @Override
    public LocalDate getLeaseEndDate() {
        return leaseEndDate;
    }

    @Override
    public void extendLease(final int days) {
        if (days > 0) {
            leaseEndDate = leaseEndDate.plusDays(days);

            final Osoba tenant = getTenant();

            for (final File letter : tenant.getLetters()) {
                final Optional<Room> optionalRoom = Room.fromFile(letter);
                if (optionalRoom.isPresent() && optionalRoom.get().equals(this)) {
                    tenant.getLetters().remove(letter);
                }
            }
        }
    }

    @Override
    public boolean isCleared() {
        return cleared;
    }

    @Override
    public void clear() {
        if (!cleared) {
            this.cleared = true;
            people.clear();
            Logger.LEASE.log("All people have been evicted from Mieszkanie" + id);
        }
    }

    @Override
    public boolean isExpired() {
        return expired;
    }

    @Override
    public void setExpired(boolean expired) {
        this.expired = expired;
        if (expired) {
            try {
                final File file = new File("Mieszkanie" + id + "-" + TimeUtil.getDate().toString());
                if (file.createNewFile()) {
                    final Osoba tenant = getTenant();

                    if (tenant != null) {
                        tenant.addLetter(file);
                        Logger.WRITE.log(tenant.getFullName() + " has been issued " + file);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Area getUsedArea() {
        return usedArea;
    }

    @Override
    public void setUsedArea(final Area usedArea) {
        this.usedArea = usedArea;
    }

    @Override
    public String toString() {
        return "Mieszkanie{" +
                "area=" + area +
                ", people=" + people +
                ", leaseStartDate=" + leaseStartDate +
                ", leaseEndDate=" + leaseEndDate +
                ", id=" + id +
                ", expired=" + expired +
                '}';
    }
}
