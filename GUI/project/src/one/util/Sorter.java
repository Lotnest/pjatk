package one.util;

import one.estate.room.Room;
import one.item.Item;
import one.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;

public class Sorter {

    public static ArrayList<Room> sortRooms(final ArrayList<Room> rooms) {
        rooms.sort(Comparator.comparing(Content::getArea));
        return rooms;
    }

    public static ArrayList<Vehicle> sortVehicles(final ArrayList<Vehicle> vehicles) {
        vehicles.sort(Comparator.comparing(Content::getArea));
        return vehicles;
    }

    public static ArrayList<Item> sortItems(final ArrayList<Item> items) {
        items.sort(Comparator.comparing(Content::getArea));
        return items;
    }
}
