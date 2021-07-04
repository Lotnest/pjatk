package two.controller;

import javafx.application.Platform;
import two.model.Time;

import java.util.Timer;
import java.util.TimerTask;

public class TimeController {

    private final Time time;
    private boolean initialized;
    private Timer timer;
    private final MemoryCardController memoryCardController;

    public TimeController(final Time time, final MemoryCardController memoryCardController) {
        this.time = time;
        this.memoryCardController = memoryCardController;
    }

    public Time getTime() {
        return time;
    }

    public MemoryCardController getMemoryCardController() {
        return memoryCardController;
    }

    public void updateTime() {
        time.setSeconds(time.getSeconds() + 1);
        memoryCardController.timeLabel.setText("Time passed: " + time.getSeconds());
    }

    public void initialize() {
        if (!initialized) {
            initialized = true;
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> updateTime());
                }
            }, 0, 1000);
        } else {
            throw new IllegalStateException("Time already initialized");
        }
    }

    public void stop() {
        if (!initialized) {
            throw new IllegalStateException("Time is not initialized");
        } else {
            timer.cancel();
        }
    }
}
