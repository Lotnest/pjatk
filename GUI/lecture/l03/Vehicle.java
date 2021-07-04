package lecture.l03;

public interface Vehicle {

    int maxSpeed = 140;

    void startEngine();

    void move();

    default boolean engineCheckTime(int km) {
        return km >= 10000;
    }
}
