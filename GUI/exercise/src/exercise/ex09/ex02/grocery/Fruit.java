package exercise.ex09.ex02.grocery;

public enum Fruit implements Food {

    APPLE("Apple"),
    ORANGE("Orange"),
    STRAWBERRY("Strawberry");

    private final String name;

    Fruit(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
