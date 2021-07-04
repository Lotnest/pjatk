package lecture.l03;

public class Car implements Vehicle {

    private final int currentRange;

    public Car() {
        this.currentRange = 0;
    }

    @Override
    public void startEngine() {
        if (engineCheckTime(currentRange)) {

        }
    }

    @Override
    public void move() {

    }
}
