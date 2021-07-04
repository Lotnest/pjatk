package one.person;

import one.estate.room.Room;
import one.util.Logger;
import one.util.Validator;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Osoba {

    private String name;
    private String lastName;
    private String PESEL;
    private Address address;
    private LocalDate birthDate;
    private final HashSet<File> letters = new HashSet<>();

    public Osoba(final String name, final String lastName, final String PESEL, final Address address, final LocalDate birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.PESEL = Validator.validatePESEL(PESEL);
        this.address = address;
        this.birthDate = birthDate;

        Logger.DEBUG.log("Initialized " + this);
    }

    public static List<Osoba> getPeople() {
        final ArrayList<Osoba> people = new ArrayList<>();
        for (final Room room : Room.rooms.values()) {
            people.addAll(room.getPeople());
        }
        return people.stream().distinct().collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return name + " " + lastName;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(final String PESEL) {
        this.PESEL = PESEL;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public HashSet<File> getLetters() {
        return letters;
    }

    public boolean addLetter(File letter) {
        return letters.add(letter);
    }

    public boolean removeLetter(File letter) {
        return letters.remove(letter);
    }

    public List<Room> getRentals() {
        return Room.rooms.values().stream().filter(room -> room.getTenant().equals(this)).distinct().collect(Collectors.toList());
    }

    public HashSet<Room> getLetterRooms() {
        final HashSet<Room> letterRooms = new HashSet<>();
        for (final File letter : letters) {
            Room.fromFile(letter).ifPresent(letterRooms::add);
        }
        return letterRooms;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Osoba osoba = (Osoba) o;
        return Objects.equals(name, osoba.name) && Objects.equals(lastName, osoba.lastName) && Objects.equals(PESEL, osoba.PESEL) && Objects.equals(address, osoba.address) && Objects.equals(birthDate, osoba.birthDate) && Objects.equals(letters, osoba.letters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, PESEL, address, birthDate, letters);
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", address=" + address +
                ", birthDate=" + birthDate +
                ", letters=" + letters +
                '}';
    }
}
