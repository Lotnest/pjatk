package one.estate;

import one.estate.room.Area;
import one.estate.room.MiejsceParkingowe;
import one.estate.room.Room;
import one.estate.room.flat.FlatBlock;
import one.item.Item;
import one.person.Address;
import one.person.Osoba;
import one.util.Logger;
import one.util.Sorter;
import one.vehicle.Cherokee;
import one.vehicle.OpelCorsa;
import one.vehicle.Vehicle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Estate {

    private final ArrayList<FlatBlock> flatBlocks;

    public Estate(final ArrayList<FlatBlock> flatBlocks) {
        this.flatBlocks = flatBlocks;

        Logger.DEBUG.log("Initialized " + this);
    }

    public ArrayList<FlatBlock> getFlatBlocks() {
        return flatBlocks;
    }

    public File saveToFile() {
        final File file = new File("Estate.yml");
        try {
            if (file.createNewFile()) {
                final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

                //Estate
                bufferedWriter.write("Estate:");

                //FlatBlocks
                bufferedWriter.write("\n\tFlatBlocks:");

                int flatBlockId = 0;

                for (final FlatBlock flatBlock : flatBlocks) {
                    //FlatBlock + ID
                    bufferedWriter.write("\n\t\tFlatBlock" + flatBlockId++ + ":");

                    //Rooms
                    bufferedWriter.write("\n\t\t\tRooms:");

                    //Room
                    for (final Room room : Sorter.sortRooms(new ArrayList<>(Room.rooms.values()))) {
                        appendRoom(bufferedWriter, room);
                    }
                }

                bufferedWriter.close();
                Logger.WRITE.log(file.getName() + " was created with the current state of Estate");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private void appendRoom(final BufferedWriter bufferedWriter, final Room room) {
        try {
            //Append common properties of any room

            //Room's class name + ID
            bufferedWriter.write("\n\t\t\t\t" + room.getClass().getSimpleName() + room.getId() + ":");

            //Area
            final Area area = room.getArea();
            bufferedWriter.append("\n\t\t\t\t\tArea:")
                    .append("\n\t\t\t\t\t\tX: ")
                    .append(String.valueOf(area.getX()))
                    .append("\n\t\t\t\t\t\tY: ")
                    .append(String.valueOf(area.getY()))
                    .append("\n\t\t\t\t\t\tZ: ")
                    .append(String.valueOf(area.getZ()))
                    .append("\n\t\t\t\t\t\tVolume: ")
                    .append(String.valueOf(area.getVolume()));

            //People
            int personID = 0;
            bufferedWriter.write("\n\t\t\t\t\tPeople:");

            for (final Osoba person : room.getPeople()) {
                //Osoba + ID
                bufferedWriter.write("\n\t\t\t\t\t\tOsoba" + personID++ + ":");

                final Address personAddress = person.getAddress();

                bufferedWriter.append("\n\t\t\t\t\t\t\tName: ")
                        .append(person.getName())
                        .append("\n\t\t\t\t\t\t\tLastName: ")
                        .append(person.getLastName())
                        .append("\n\t\t\t\t\t\t\tPESEL: ")
                        .append(person.getPESEL())
                        .append("\n\t\t\t\t\t\t\tAddress: ")
                        .append("\n\t\t\t\t\t\t\t\tStreet: ")
                        .append(personAddress.getStreet())
                        .append("\n\t\t\t\t\t\t\t\tZIPCode: ")
                        .append(personAddress.getZIPCode())
                        .append("\n\t\t\t\t\t\t\t\tCity: ")
                        .append(personAddress.getCity())
                        .append("\n\t\t\t\t\t\t\t\tCountry: ")
                        .append(personAddress.getCountry());
            }

            //LeaseStartDate
            bufferedWriter.write("\n\t\t\t\t\tLeaseStartDate: " + room.getLeaseStartDate().toString());

            //LeaseEndDate
            bufferedWriter.write("\n\t\t\t\t\tLeaseEndDate: " + room.getLeaseEndDate().toString());

            //Expired
            bufferedWriter.write("\n\t\t\t\t\tExpired: " + room.isExpired());

            //UsedArea
            final Area usedArea = room.getUsedArea();
            bufferedWriter.append("\n\t\t\t\t\tUsedArea:")
                    .append("\n\t\t\t\t\t\tX: ")
                    .append(String.valueOf(usedArea.getX()))
                    .append("\n\t\t\t\t\t\tY: ")
                    .append(String.valueOf(usedArea.getY()))
                    .append("\n\t\t\t\t\t\tZ: ")
                    .append(String.valueOf(usedArea.getZ()))
                    .append("\n\t\t\t\t\t\tVolume: ")
                    .append(String.valueOf(usedArea.getVolume()));

            //Cleared
            bufferedWriter.write("\n\t\t\t\t\tCleared: " + room.isCleared());

            //Append MiejsceParkingowe's unique properties
            if (room instanceof MiejsceParkingowe) {
                final MiejsceParkingowe miejsceParkingowe = (MiejsceParkingowe) room;

                //Vehicles
                int vehicleID = 0;
                bufferedWriter.append("\n\t\t\t\t\tVehicles:");
                for (final Vehicle vehicle : Sorter.sortVehicles(miejsceParkingowe.getVehicles())) {
                    //Append common Vehicle properties

                    //Vehicle's class name + ID
                    bufferedWriter.write("\n\t\t\t\t\t\t" + vehicle.getClass().getSimpleName() + vehicleID++ + ":");

                    //Area
                    final Area vehicleArea = vehicle.getArea();
                    bufferedWriter.append("\n\t\t\t\t\t\t\tArea:")
                            .append("\n\t\t\t\t\t\t\t\tX: ")
                            .append(String.valueOf(vehicleArea.getX()))
                            .append("\n\t\t\t\t\t\t\t\tY: ")
                            .append(String.valueOf(vehicleArea.getY()))
                            .append("\n\t\t\t\t\t\t\t\tZ: ")
                            .append(String.valueOf(vehicleArea.getZ()))
                            .append("\n\t\t\t\t\t\t\t\tVolume: ")
                            .append(String.valueOf(vehicleArea.getVolume()));

                    //FuelCapacity
                    bufferedWriter.write("\n\t\t\t\t\t\t\tFuelCapacity: " + vehicle.getFuelCapacity());

                    //VehicleType
                    bufferedWriter.write("\n\t\t\t\t\t\t\tVehicleType: " + vehicle.getVehicleType());

                    //EngineType
                    bufferedWriter.write("\n\t\t\t\t\t\t\tEngineType: " + vehicle.getEngineType());

                    //Append Cherokee's unique properties
                    if (vehicle instanceof Cherokee) {
                        //WheelDriveType
                        bufferedWriter.write("\n\t\t\t\t\t\t\tWheelDriveType: " + ((Cherokee) vehicle).getWheelDriveType());
                    }

                    //Append OpelCorsa's unique properties
                    if (vehicle instanceof OpelCorsa) {
                        //GearboxType
                        bufferedWriter.write("\n\t\t\t\t\t\t\tGearboxType: " + ((OpelCorsa) vehicle).getGearboxType());
                    }

                    //TODO add more vehicles
                }

                //Items
                int itemID = 0;
                bufferedWriter.append("\n\t\t\t\t\tItems:");
                for (final Item item : Sorter.sortItems(miejsceParkingowe.getItems())) {
                    //Item + ID
                    bufferedWriter.write("\n\t\t\t\t\t\tItem" + itemID++ + ":");

                    //Name
                    bufferedWriter.write("\n\t\t\t\t\t\t\tName: " + item.getName());

                    //Area
                    final Area itemArea = item.getArea();
                    bufferedWriter.append("\n\t\t\t\t\t\t\tArea:")
                            .append("\n\t\t\t\t\t\t\t\tX: ")
                            .append(String.valueOf(itemArea.getX()))
                            .append("\n\t\t\t\t\t\t\t\tY: ")
                            .append(String.valueOf(itemArea.getY()))
                            .append("\n\t\t\t\t\t\t\t\tZ: ")
                            .append(String.valueOf(itemArea.getZ()))
                            .append("\n\t\t\t\t\t\t\t\tVolume: ")
                            .append(String.valueOf(itemArea.getVolume()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Estate estate = (Estate) o;
        return Objects.equals(flatBlocks, estate.flatBlocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flatBlocks);
    }

    @Override
    public String toString() {
        return "Estate{" +
                "flatBlocks=" + flatBlocks +
                '}';
    }
}
