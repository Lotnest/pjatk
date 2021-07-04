package one.vehicle;

import one.estate.room.Area;
import one.vehicle.type.EngineType;
import one.vehicle.type.GearboxType;
import one.vehicle.type.VehicleType;

public class OpelCorsa implements Vehicle {

    private final String name = "Opel Corsa";
    private final Area area = new Area(4.2, 1.76, 1.63);
    private final int fuelCapacity = 138;
    private final VehicleType vehicleType = VehicleType.OFF_ROAD_CAR;
    private final EngineType engineType = EngineType.DIESEL;
    private final GearboxType gearboxType = GearboxType.MANUAL;

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

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    @Override
    public String toString() {
        return "OpelCorsa{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", fuelCapacity=" + fuelCapacity +
                ", vehicleType=" + vehicleType +
                ", engineType=" + engineType +
                ", gearboxType=" + gearboxType +
                '}';
    }
}
