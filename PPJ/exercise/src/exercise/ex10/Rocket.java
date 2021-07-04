package exercise.ex10;

import java.security.SecureRandom;

public class Rocket {

    private final String name;
    private int fuelWeight;

    public Rocket(String name, int fuelWeight) {
        this.name = name;
        this.fuelWeight = fuelWeight;
    }

    public String getName() {
        return name;
    }

    public void refuel() {
        fuelWeight = new SecureRandom().nextInt();
    }

    public void start() {
        if (fuelWeight < 1000) {
            try {
                throw new Exception("Start cancelled - too few fuel");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
