package one.vehicle;

import one.estate.room.Area;
import one.vehicle.type.EngineType;
import one.vehicle.type.VehicleType;

public class Olympia570Holiday implements Vehicle {

    private final String name = "Olympia 570 Holiday";
    private final Area area = new Area(5.5, 2.07, 2.07);
    private final int fuelCapacity = 60;
    private final VehicleType vehicleType = VehicleType.BOAT;
    private final EngineType engineType = EngineType.PETROL;
    private final boolean cabin = true;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Area getArea() {
        return area;
    }

    @Override
    public int getFuelCapacity() {
        return fuelCapacity;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public EngineType getEngineType() {
        return engineType;
    }

    public boolean getCabin() {
        return cabin;
    }

    @Override
    public String toString() {
        return "Olympia570Holiday{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", fuelCapacity=" + fuelCapacity +
                ", vehicleType=" + vehicleType +
                ", engineType=" + engineType +
                ", cabin=" + cabin +
                '}';
    }
}
