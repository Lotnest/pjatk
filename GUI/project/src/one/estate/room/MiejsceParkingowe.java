package one.estate.room;

import one.item.Item;
import one.person.Osoba;
import one.util.Logger;
import one.util.TimeUtil;
import one.util.TooManyThingsException;
import one.util.Validator;
import one.vehicle.Vehicle;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

public class MiejsceParkingowe implements Room {

    private final Area area;
    private final LinkedList<Osoba> people;
    private final LocalDate leaseStartDate;
    private LocalDate leaseEndDate;
    private final int id = Room.getNextId();
    private boolean expired;
    private Area usedArea;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Item> items;
    private boolean cleared;

    public MiejsceParkingowe(final Area area, final LinkedList<Osoba> people, final LocalDate leaseStartDate, final LocalDate leaseEndDate) {
        this.area = area;
        this.people = people;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        if (!rooms.containsKey(id)) {
            rooms.put(id, this);
        }
        setExpired(false);
        setUsedArea(new Area(0));
        setVehicles(new ArrayList<>());
        setItems(new ArrayList<>());

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
            vehicles.clear();
            items.clear();
            Logger.LEASE.log("All vehicles have been sold from MiejsceParkingowe" + id);
            Logger.LEASE.log("All items have been removed from MiejsceParkingowe" + id);
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
                final File file = new File("MiejsceParkingowe" + id + "-" + TimeUtil.getDate().toString());
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

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(final ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(final ArrayList<Item> items) {
        this.items = items;
    }

    public void addVehicle(final Vehicle vehicle) {
        final Area vehicleArea = vehicle.getArea();
        if (getUsedArea().getVolume() > 0 && getUsedArea().compareTo(vehicleArea) < 0) {
            try {
                throw new TooManyThingsException("Remove some old items to insert a new item");
            } catch (TooManyThingsException e) {
                e.printStackTrace();
            }
        } else {
            final Area areaCopy = getUsedArea();

            setUsedArea(getUsedArea().add(vehicleArea));
            vehicles.add(vehicle);

            //Check if usable area is bigger than total area
            if (getArea().compareTo(getUsedArea()) < 0) {
                setUsedArea(areaCopy);
                vehicles.remove(vehicle);
                try {
                    throw new TooManyThingsException("Remove some old items to insert a new item");
                } catch (TooManyThingsException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Added " + vehicle.getName() + " to MiejsceParkingowe" + id + ".");
            }
        }
    }

    public void removeVehicle(final Vehicle vehicle) {
        vehicles.remove(vehicle);
        System.out.println("Removed " + vehicle.getName() + " from MiejsceParkingowe" + id + ".");
    }

    public void addItem(final Item item) {
        final Area itemArea = item.getArea();
        if (getUsedArea().compareTo(itemArea) < 0) {
            try {
                throw new TooManyThingsException("Remove some old items to insert a new item");
            } catch (TooManyThingsException e) {
                e.printStackTrace();
            }
        } else {
            final Area areaCopy = getUsedArea();

            setUsedArea(getUsedArea().add(itemArea));
            items.add(item);

            //Check if usable area is bigger than total area
            if (getArea().compareTo(getUsedArea()) < 0) {
                setUsedArea(areaCopy);
                items.remove(item);
                try {
                    throw new TooManyThingsException("Remove some old items to insert a new item");
                } catch (TooManyThingsException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void removeItem(final Item item) {
        items.remove(item);
        System.out.println("Removed " + item + " from MiejsceParkingowe" + id + ".");
    }

    public void removeContent(final Object object) {
        if (object instanceof Vehicle) {
            removeVehicle((Vehicle) object);
        } else if (object instanceof Item) {
            removeItem((Item) object);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final MiejsceParkingowe that = (MiejsceParkingowe) o;
        return id == that.id && expired == that.expired && Objects.equals(area, that.area) && Objects.equals(people, that.people) && Objects.equals(leaseStartDate, that.leaseStartDate) && Objects.equals(leaseEndDate, that.leaseEndDate) && Objects.equals(usedArea, that.usedArea) && Objects.equals(vehicles, that.vehicles) && Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, people, leaseStartDate, leaseEndDate, id, expired, usedArea, vehicles, items);
    }

    @Override
    public String toString() {
        return "MiejsceParkingowe{" +
                "area=" + area +
                ", people=" + people +
                ", leaseStartDate=" + leaseStartDate +
                ", leaseEndDate=" + leaseEndDate +
                ", id=" + id +
                ", expired=" + expired +
                ", usedArea=" + usedArea +
                ", vehicles=" + vehicles +
                ", items=" + items +
                '}';
    }
}
