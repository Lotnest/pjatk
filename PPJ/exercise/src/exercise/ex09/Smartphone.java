package exercise.ex09;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Smartphone extends CellPhone {

    private Person[] contacts;

    public Smartphone(String communicationInterface, String color, Person[] contacts) {
        super(communicationInterface, color);
        this.contacts = contacts;
    }

    public Person[] getContacts() {
        return contacts;
    }

    public void setContacts(Person[] contacts) {
        this.contacts = contacts;
        String s = Arrays.stream(contacts).map(Person::toString).collect(Collectors.joining(", "));
    }
}
