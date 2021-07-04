package one.vehicle.type;

public enum WheelDriveType {

    FOUR_BY_FOUR("4x4"),
    TWO_BY_TWO("2x2");

    private final String name;

    WheelDriveType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
