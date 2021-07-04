package one.vehicle.type;

public enum VehicleType {

    OFF_ROAD_CAR("Off-road car"),
    CITY_CAR("City car"),
    BOAT("Boat"),
    MOTORCYCLE("Motorcycle"),
    AMPHIBIOUS("Amphibious");

    private final String name;

    VehicleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
