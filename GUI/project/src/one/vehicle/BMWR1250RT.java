package one.vehicle;

import one.estate.room.Area;
import one.vehicle.type.EngineType;
import one.vehicle.type.VehicleType;

public class BMWR1250RT implements Vehicle {

    private final String name = "BMW R 1250 RT";
    private final Area area = new Area(2.22, 1.46, 0.98);
    private final int fuelCapacity = 1254;
    private final VehicleType vehicleType = VehicleType.MOTORCYCLE;
    private final EngineType engineType = EngineType.PETROL;
    private final boolean chain = false;

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

    public boolean getChain() {
        return chain;
    }

    @Override
    public String toString() {
        return "BMWR1250RT{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", fuelCapacity=" + fuelCapacity +
                ", vehicleType=" + vehicleType +
                ", engineType=" + engineType +
                ", chain=" + chain +
                '}';
    }
}
