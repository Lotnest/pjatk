package exercise.ex08;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Person {

    private final String name;
    private final int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public Person(String name) {
        this.name = name;
        this.birthYear = 1990;
    }

    public static Person getOlder(Person person1, Person person2) {
        return person1.getAge() > person2.getAge() ? person1 : person2;
    }

    public static Person getOldest(Person[] people) {
        Optional<Person> max = Arrays.stream(people).max(Comparator.comparingInt(Person::getAge));
        return max.orElse(null);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthYear;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    public static void main(String[] args) {
        Person person1 = new Person("Test");
        Person person2 = new Person("Test2", 2001);
        System.out.println(Person.getOlder(person1, person2));

        Person[] people = new Person[5];
        people[0] = new Person("Test", 1100);
        people[1] = new Person("Test1", 1200);
        people[2] = new Person("Test2", 1300);
        people[3] = new Person("Test3", 1400);
        people[4] = new Person("Test4", 1500);
        System.out.println(Person.getOldest(people));
    }
}
