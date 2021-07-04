package one;

import one.estate.Developer;
import one.estate.Estate;
import one.estate.room.Area;
import one.estate.room.MiejsceParkingowe;
import one.estate.room.flat.FlatBlock;
import one.estate.room.flat.Mieszkanie;
import one.item.Item;
import one.person.Address;
import one.person.Osoba;
import one.util.Logger;
import one.util.TimeUtil;
import one.vehicle.Cherokee;

import java.io.File;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static final boolean DEBUG = false;
    private static Estate estate;

    public static void main(String[] args) {
        //Cleanup files from previous run
        for (final File file : Objects.requireNonNull(new File(".").listFiles())) {
            if (file.getName().matches("MiejsceParkingowe\\d-.*") || file.getName().matches("Mieszkanie\\d-.*") || file.getName().equals("Estate.yml")) {
                if (file.delete()) {
                    Logger.DELETE.log(file);
                }
            }
        }

        new TimeUtil().start();

        final ArrayList<Osoba> people = new ArrayList<>();

        people.add(new Osoba(
                "Marcin",
                "Testowy",
                "01234567890",
                new Address(
                        "Testowa 26/27",
                        "01-111",
                        "Warszawa",
                        "Polska"
                ),
                TimeUtil.getDate()
        ));

        people.add(new Osoba(
                "Paweł",
                "Nietestowy",
                "79876543210",
                new Address(
                        "Kolorowa 100",
                        "09-999",
                        "Łódź",
                        "Polska"
                ),
                TimeUtil.getDate()
        ));

        people.add(new Osoba(
                "Michał",
                "Michalski",
                "21455541399",
                new Address(
                        "Centralna 4",
                        "02-345",
                        "Kalisz",
                        "Polska"
                ),
                TimeUtil.getDate()
        ));

        people.add(new Osoba(
                "Kasia",
                "Woźniak",
                "85451332157",
                new Address(
                        "Marszałkowska 23/87",
                        "06-631",
                        "Warszawa",
                        "Polska"
                ),
                TimeUtil.getDate()
        ));

        people.add(new Osoba(
                "Sandra",
                "GUI",
                "13145663453",
                new Address(
                        "Wolna 17/34",
                        "07-417",
                        "Kraków",
                        "Polska"
                ),
                TimeUtil.getDate()
        ));

        final Random random = new Random();

        final ArrayList<Mieszkanie> flats = new ArrayList<>();
        IntStream.range(1, 5).forEach(i -> {
            final Mieszkanie mieszkanie = new Mieszkanie(
                    new Area(random.nextInt(99) + 1, random.nextInt(99) + 1, random.nextInt(99) + 1),
                    new LinkedList<>(Collections.singleton(people.get(random.nextInt(people.size())))),
                    TimeUtil.getDate(),
                    TimeUtil.getDate().plusDays(i)
            );
            flats.add(mieszkanie);
        });

        final ArrayList<MiejsceParkingowe> parkingSpots = new ArrayList<>();
        IntStream.range(1, 5).forEach(i -> {
            final MiejsceParkingowe miejsceParkingowe = new MiejsceParkingowe(
                    new Area(random.nextInt(99) + 1, random.nextInt(99) + 1, random.nextInt(99) + 1),
                    new LinkedList<>(Collections.singleton(people.get(random.nextInt(people.size())))),
                    TimeUtil.getDate(),
                    TimeUtil.getDate().plusDays(i)
            );
            parkingSpots.add(miejsceParkingowe);
        });

        final Developer developer = new Developer("abc 123");
        final FlatBlock flatBlock = new FlatBlock(flats, parkingSpots);
        developer.setEstates(new ArrayList<>(Collections.singleton(estate = new Estate(new ArrayList<>(Collections.singleton(flatBlock))))));
        Logger.DEBUG.log(developer);

        final MiejsceParkingowe parkingSpot = flatBlock.getParkingSpots().get(0);
        parkingSpot.addVehicle(new Cherokee());
        parkingSpot.addItem(Item.BOX);
        Logger.DEBUG.log(parkingSpot);

        Menu.initializeActionListener();
    }

    public static Estate getEstate() {
        return estate;
    }
}
