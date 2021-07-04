package exercise.ex09.ex02.grocery;

public enum Vegetable implements Food {

    POTATO("Potato"),
    CAULIFLOWER("Cauliflower"),
    BEETROOT("Beetroot");

    private final String name;

    Vegetable(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
