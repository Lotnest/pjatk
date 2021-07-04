package one.vehicle;

import one.estate.room.Area;
import one.vehicle.type.EngineType;
import one.vehicle.type.VehicleType;
import one.vehicle.type.WheelDriveType;

public class Cherokee implements Vehicle {

    private final String name = "Cherokee";
    private final Area area = new Area(4.2, 1.76, 1.63);
    private final int fuelCapacity = 220;
    private final VehicleType vehicleType = VehicleType.OFF_ROAD_CAR;
    private final EngineType engineType = EngineType.DIESEL;
    private final WheelDriveType wheelDriveType = WheelDriveType.FOUR_BY_FOUR;

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

    public WheelDriveType getWheelDriveType() {
        return wheelDriveType;
    }

    @Override
    public String toString() {
        return "Cherokee{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", fuelCapacity=" + fuelCapacity +
                ", vehicleType=" + vehicleType +
                ", engineType=" + engineType +
                ", wheelDriveType=" + wheelDriveType +
                '}';
    }
}
