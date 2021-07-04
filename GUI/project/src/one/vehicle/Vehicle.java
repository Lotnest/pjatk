package one.vehicle;

import one.estate.room.Area;
import one.util.Content;
import one.vehicle.type.EngineType;
import one.vehicle.type.VehicleType;

public interface Vehicle extends Content {

    String getName();

    Area getArea();

    int getFuelCapacity();

    VehicleType getVehicleType();

    EngineType getEngineType();
}
