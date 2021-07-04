package exercise.ex05.ex04;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Person kowalski = new Person("Jan", "Kowalski");
        Person nowak = new Person("Adam", "Nowak");
        Person krawczyk = new Person("Bartosz", "Krawczyk");
        Person heniek = new Person("Kierownik", "Heniek");

        Car skoda1 = new Car("WA00001", "Skoda");
        Car skoda2 = new Car("SC36010", "Skoda");
        Car mazda1 = new Car("WA01234", "Mazda");
        Car mazda2 = new Car("DW01ASD", "Mazda");
        Car bmw = new Car("WA12690", "BMW");
        Car volvo = new Car("KR60606", "Volvo");

        /*
        Jan Kowalski -> SKODA WA00001, BMW WA12690
        Adam Nowak -> MAZDA DW01ASD
        Bartosz Krawczyk -> VOLVO KR60606, MAZDA WA01234, SKODA SC36010
        Kierownik Heniek -> [Brak samochodów]
         */
        HashMap<Person, List<Car>> carOwnersMap = new HashMap<>();
        carOwnersMap.put(kowalski, Arrays.asList(skoda1, bmw));

        carOwnersMap.put(nowak, Collections.singletonList(mazda2));

        carOwnersMap.put(krawczyk, Arrays.asList(volvo, mazda1, skoda2));

        for (Map.Entry<Person, List<Car>> entry : carOwnersMap.entrySet()) {
            System.out.println(entry.getKey() + " posiada " + entry.getValue().size() + " pojazdy");
        }
        System.out.println("\n" + carOwnersMap.get(nowak).get(0) + "\n");
        carOwnersMap.forEach((osoba, samochody) -> samochody.stream()
                .filter(samochod -> samochod.getLicensePlate().startsWith("WA"))
                .forEach(System.out::println));
    }
}
