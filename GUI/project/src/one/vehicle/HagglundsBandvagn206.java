package one.vehicle;

import one.estate.room.Area;
import one.vehicle.type.EngineType;
import one.vehicle.type.VehicleType;

public class HagglundsBandvagn206 implements Vehicle {

    private final String name = "Hagglunds Bandvagn 206";
    private final Area area = new Area(6.9, 2.4, 1.87);
    private final int fuelCapacity = 80;
    private final VehicleType vehicleType = VehicleType.AMPHIBIOUS;
    private final EngineType engineType = EngineType.DIESEL;
    private final boolean mortars = true;

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

    public boolean getMortars() {
        return mortars;
    }

    @Override
    public String toString() {
        return "HagglundsBandvagn206{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", fuelCapacity=" + fuelCapacity +
                ", vehicleType=" + vehicleType +
                ", engineType=" + engineType +
                ", mortars=" + mortars +
                '}';
    }
}
