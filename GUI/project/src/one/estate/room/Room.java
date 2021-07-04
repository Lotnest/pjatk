package one.estate.room;

import one.person.Osoba;
import one.util.Content;
import one.util.Logger;
import one.util.TimeUtil;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;

public interface Room extends Content {

    HashMap<Integer, Room> rooms = new HashMap<>();

    int getId();

    Area getArea();

    LinkedList<Osoba> getPeople();

    Osoba getTenant();

    void setTenant(final Osoba tenant);

    void addPerson(Osoba osoba);

    void removePerson(Osoba osoba);

    LocalDate getLeaseStartDate();

    LocalDate getLeaseEndDate();

    void extendLease(final int days);

    boolean isCleared();

    void clear();

    boolean isExpired();

    void setExpired(final boolean expired);

    Area getUsedArea();

    void setUsedArea(final Area usedArea);

    static int getNextId() {
        final int roomsSize = rooms.size();
        return roomsSize == 0 ? 0 : roomsSize + 1;
    }

    static Optional<Room> getRoomById(final int id) {
        return Optional.ofNullable(rooms.get(id));
    }

    default void checkLeaseExpire() {
        if (TimeUtil.getDate().toEpochDay() >= getLeaseEndDate().toEpochDay()) {
            if (!isExpired()) {
                setExpired(true);
                Logger.LEASE.log("Lease expired: " + getClass().getSimpleName() + getId() + ". " + getTenant().getFullName() + " has 30 days to settle the payment.");
            } else {
                getTenant().getLetters().forEach(letter -> {
                    final Optional<LocalDate> optionalLocalDate = dateFromFile(letter);
                    if (optionalLocalDate.isPresent() && TimeUtil.getDate().toEpochDay() - optionalLocalDate.get().toEpochDay() > 30) {
                        fromFile(letter).ifPresent(Room::clear);
                    }
                });
            }
        }
    }

    static void checkLeaseExpireAll() {
        rooms.values().forEach(Room::checkLeaseExpire);
        Logger.DEBUG.log("Checked all leases' expiration");
    }

    static Optional<LocalDate> dateFromFile(final File file) {
        if (file != null && file.isFile() && file.exists()) {
            return Optional.of(LocalDate.parse(file.getName().replaceAll("Mieszkanie\\d-", "").replaceAll("MiejsceParkingowe\\d-", "")));
        }
        return Optional.empty();
    }

    static Optional<Room> fromFile(final File file) {
        return Optional.ofNullable(rooms.get(Integer.parseInt(String.valueOf(file.getName().replaceAll("Mieszkanie", "").replaceAll("MiejsceParkingowe", "").charAt(0)))));
    }

    static HashSet<Room> getEmptyRooms() {
        final HashSet<Room> emptyRooms = new HashSet<>();
        rooms.values().forEach(room -> {
            if (room.getTenant() == null) {
                emptyRooms.add(room);
            }
        });
        return emptyRooms;
    }

    static Optional<Room> rent(final Osoba tenant, final int id) {
        if (tenant != null) {
            final Room room = rooms.get(id);
            if (room != null && room.getTenant() == null) {
                room.setTenant(tenant);
                return Optional.of(room);
            }
        }
        return Optional.empty();
    }
}
