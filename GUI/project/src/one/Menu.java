package one;

import one.estate.room.MiejsceParkingowe;
import one.estate.room.Room;
import one.person.Osoba;
import one.util.Logger;
import one.vehicle.*;

import java.util.*;
import java.util.stream.Collectors;

public class Menu {

    private static Osoba currentPerson = null;
    private static Scanner scanner;

    public static void initializeActionListener() {
        scanner = new Scanner(System.in);
        action(-1);
        while (scanner.hasNext()) {
            final String next = scanner.next();
            try {
                action(Integer.parseInt(next));
            } catch (NumberFormatException e) {
                if (next.equalsIgnoreCase("back")) {
                    action(-1);
                }
            }
        }
    }

    private static void action(int action) {
        //Po uruchomieniu programu, użytkownik powinien mieć możliwość za pośrednictwem konsoli poleceń wywołania wszystkich wspomnianych funkcjonalności. Są to m.in:
        switch (action) {
            //zakończenia programu w dowolnym momencie
            case 0:
                System.exit(-1);
                break;
            //wybrania którą jest osobą (nie jest potrzebne żadne logowanie, wystarczy wskazanie np. unikalnego numeru osoby)
            case 1:
                Logger.MENU.log("\nEnter the person's PESEL or type 'back' to go back.\n");

                final String PESEL = scanner.next();
                for (final Room room : Room.rooms.values()) {
                    for (final Osoba person : room.getPeople()) {
                        if (person.getPESEL().equals(PESEL)) {
                            currentPerson = person;
                        }
                    }
                }
                if (currentPerson == null) {
                    Logger.MENU.log("\nPerson with given PESEL does not exist.\n");
                } else {
                    Logger.MENU.log("\nYou are now " + currentPerson.getFullName() + ".\n");
                }
                break;
            //wypisania swoich danych łącznie z wynajętymi pomieszczeniami
            case 2:
                final ArrayList<String> test = new ArrayList<>(Collections.singleton("test"));
                test.forEach(System.out::println);

                if (isCurrentPersonSelected()) {
                    Logger.MENU.log(currentPerson);

                    final HashSet<Room> rooms = Room.rooms.values().stream()
                            .filter(room -> room.getTenant().equals(currentPerson))
                            .collect(Collectors.toCollection(HashSet::new));
                    Logger.MENU.log(rooms.isEmpty() ? "You are not renting any rooms." : "Rooms rented: " + rooms + "\n");
                }
                break;
            //wyświetlenia wolnych pomieszczeń
            case 3:
                final HashSet<Room> emptyRooms = Room.getEmptyRooms();
                Logger.MENU.log(emptyRooms.isEmpty() ? "There are no empty rooms." : "Empty rooms: " + emptyRooms + "\n");
                break;
            //wynajęcia nowego pomieszczenia, po uprzednim jego wybraniu
            case 4:
                if (isCurrentPersonSelected()) {
                    Logger.MENU.log("\nEnter the room's id or type 'back' to go back.\n");
                    final String next = scanner.next();
                    try {
                        final Optional<Room> optionalRoom = Room.rent(currentPerson, Integer.parseInt(next));
                        optionalRoom.ifPresentOrElse(room -> Logger.MENU.log("You are now renting room " + room.getId() + "."),
                                () -> Logger.MENU.log("That room is already rented or does not exist."));
                    } catch (NumberFormatException e) {
                        if (!next.equalsIgnoreCase("back")) {
                            Logger.MENU.log("\nEnter the room's id or type 'back' to go back.\n");
                        }
                    }
                }
                break;
            //wybrania pomieszczenia które wynajmuje dana osoba oraz wyświetlenia zawartości pomieszczenia
            case 5:
                final List<Osoba> people = Osoba.getPeople();
                if (!people.isEmpty()) {
                    Logger.MENU.log("Select a person by typing the corresponding id:");
                    printPeople(people);

                    try {
                        currentPerson = people.get(Integer.parseInt(scanner.next()));
                        if (currentPerson == null) {
                            Logger.MENU.log("Please enter a valid id given above.");
                        } else {
                            final List<Room> rentedRooms = currentPerson.getRentals();
                            Logger.MENU.log(rentedRooms.isEmpty() ? currentPerson.getFullName() + " is not renting any rooms." : currentPerson.getFullName() + "'s rented rooms (select one by typing the corresponding id):" + getRentedRoomsAsMenu(rentedRooms));

                            try {
                                final Room room = rentedRooms.get(Integer.parseInt(scanner.next()));
                                Logger.MENU.log(room == null ? "Please enter a valid id given above." : getRoomContents(room));
                            } catch (IndexOutOfBoundsException e) {
                                Logger.MENU.log("Please enter a valid id given above.");
                            }
                        }
                    } catch (NumberFormatException e) {
                        Logger.MENU.log("Please enter a valid id given above.");
                    }
                } else {
                    Logger.MENU.log("There are no people to select from.");
                }
                break;
            //włożenia nowych pojazdów/przedmiotów pamiętając, aby nie przepełnić pomieszczenia
            case 6:
                if (isCurrentPersonSelected()) {
                    final List<Room> parkingSpots = currentPerson.getRentals().stream()
                            .filter(room -> room instanceof MiejsceParkingowe)
                            .collect(Collectors.toList());
                    if (parkingSpots.isEmpty()) {
                        Logger.MENU.log(currentPerson.getFullName() + " is not renting any parking spots.");
                    } else {
                        Logger.MENU.log(currentPerson.getFullName() + "'s rented parking spots (select one by typing the corresponding id):" + getRentedRoomsAsMenu(parkingSpots));
                        try {
                            final MiejsceParkingowe parkingSpot = (MiejsceParkingowe) parkingSpots.get(Integer.parseInt(scanner.next()));

                            if (parkingSpot == null) {
                                Logger.MENU.log("Please enter a valid id given above.");
                            } else {
                                final ArrayList<Vehicle> vehiclesAvailable = new ArrayList<>(Arrays.asList(
                                        new Cherokee(),
                                        new OpelCorsa(),
                                        new Olympia570Holiday(),
                                        new BMWR1250RT(),
                                        new Olympia570Holiday(),
                                        new HagglundsBandvagn206()
                                ));
                                printVehiclesAvailable(vehiclesAvailable);

                                parkingSpot.addVehicle(vehiclesAvailable.get(Integer.parseInt(scanner.next())));
                            }
                        } catch (IndexOutOfBoundsException e) {
                            Logger.MENU.log("Please enter a valid id given above.");
                        }
                    }
                }
                break;
            //wyjęcia przedmiotów lub pojazdów
            case 7:
                if (isCurrentPersonSelected()) {
                    final List<Room> parkingSpots = currentPerson.getRentals().stream()
                            .filter(room -> room instanceof MiejsceParkingowe)
                            .collect(Collectors.toList());
                    if (parkingSpots.isEmpty()) {
                        Logger.MENU.log(currentPerson.getFullName() + " is not renting any parking spots.");
                    } else {
                        Logger.MENU.log(currentPerson.getFullName() + "'s rented parking spots (select one by typing the corresponding id):" + getRentedRoomsAsMenu(parkingSpots));
                        try {
                            final MiejsceParkingowe parkingSpot = (MiejsceParkingowe) parkingSpots.get(Integer.parseInt(scanner.next()));

                            if (parkingSpot == null) {
                                Logger.MENU.log("Please enter a valid id given above.");
                            } else {
                                final ArrayList<Object> parkingSpotContents = new ArrayList<>();
                                parkingSpotContents.addAll(parkingSpot.getVehicles());
                                parkingSpotContents.addAll(parkingSpot.getItems());

                                printParkingSpotContents(parkingSpotContents);

                                final Object content = parkingSpotContents.remove(Integer.parseInt(scanner.next()));
                                if (content == null) {
                                    Logger.MENU.log("Please enter a valid id given above.");
                                } else {
                                    parkingSpot.removeContent(content);
                                }
                            }
                        } catch (IndexOutOfBoundsException e) {
                            Logger.MENU.log("Please enter a valid id given above.");
                        }
                    }
                }
                break;
            //wykonania polecenia zapisującego aktualny stan osiedla do pliku
            case 8:
                Main.getEstate().saveToFile();
                break;
            default:
                Logger.MENU.log("\nType the corresponding number to run the specific action:");
                Logger.MENU.log("0. End the program");
                Logger.MENU.log("1. Choose a person");
                Logger.MENU.log("2. Print out your data and rented rooms");
                Logger.MENU.log("3. List empty rooms");
                Logger.MENU.log("4. Rent a new room");
                Logger.MENU.log("5. Choose a room rented by a person and print the contents of it");
                Logger.MENU.log("6. Insert new vehicles or items");
                Logger.MENU.log("7. Take out items or vehicles");
                Logger.MENU.log("8. Save the current Estate state to a file\n");
                return;
        }

        try {
            Thread.sleep(1000);
            action(-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean isCurrentPersonSelected() {
        if (currentPerson == null) {
            Logger.MENU.log("\nYou have no person selected.\n");
        }
        return currentPerson != null;
    }

    private static void printPeople(final List<Osoba> people) {
        final StringBuilder stringBuilder = new StringBuilder("\n");
        for (int i = 0; i < people.size(); i++) {
            stringBuilder.append(i).append(". ").append(people.get(i)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static String getRentedRoomsAsMenu(final List<Room> rentedRooms) {
        final StringBuilder stringBuilder = new StringBuilder("\n");
        for (int i = 0; i < rentedRooms.size(); i++) {
            stringBuilder.append(i).append(". ").append(rentedRooms.get(i)).append("\n");
        }
        return stringBuilder.toString();
    }

    private static String getRoomContents(final Room room) {
        final StringBuilder stringBuilder = new StringBuilder("\n");
        stringBuilder.append(room.getClass().getSimpleName()).append(room.getId()).append("\nPeople: ").append(room.getPeople()).append("\n");

        if (room instanceof MiejsceParkingowe) {
            final MiejsceParkingowe parkingSpot = (MiejsceParkingowe) room;
            stringBuilder.append("Vehicles: ").append(parkingSpot.getVehicles()).append("\n");
            stringBuilder.append("Items: ").append(parkingSpot.getItems()).append("\n");
        }
        return stringBuilder.toString();
    }

    private static void printParkingSpotContents(final ArrayList<Object> parkingSpotContents) {
        if (parkingSpotContents == null || parkingSpotContents.isEmpty()) {
            Logger.MENU.log(currentPerson.getFullName() + " has no items or vehicles at this parking spot.");
        } else {
            final StringBuilder stringBuilder = new StringBuilder("\n");
            for (int i = 0; i < parkingSpotContents.size(); i++) {
                stringBuilder.append(i).append(". ").append(parkingSpotContents.get(i)).append("\n");
            }
            Logger.MENU.log(stringBuilder);
        }
    }

    private static void printVehiclesAvailable(final ArrayList<Vehicle> vehiclesAvailable) {
        if (vehiclesAvailable == null || vehiclesAvailable.isEmpty()) {
            Logger.MENU.log("There are no vehicles available.");
        } else {
            final StringBuilder stringBuilder = new StringBuilder("\n");
            for (int i = 0; i < vehiclesAvailable.size(); i++) {
                stringBuilder.append(i).append(". ").append(vehiclesAvailable.get(i)).append("\n");
            }
            Logger.MENU.log(stringBuilder);
        }
    }
}
