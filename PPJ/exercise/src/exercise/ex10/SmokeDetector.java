package exercise.ex10;

import java.security.SecureRandom;

public class SmokeDetector {

    public void check() {
        if (new SecureRandom().nextBoolean()) {
            try {
                throw new Alarm("The smoke detector has detected smoke");
            } catch (Alarm alarm) {
                alarm.printStackTrace();
            }
        }
    }
}
