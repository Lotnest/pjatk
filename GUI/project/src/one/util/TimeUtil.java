package one.util;

import one.estate.room.Room;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeUtil extends Thread {

    private static boolean initialized = false;
    private static LocalDate date = LocalDate.now();

    @Override
    public void run() {
        if (initialized) {
            throw new ExceptionInInitializerError("Time thread already started");
        } else {
            initialized = true;
            Logger.DEBUG.log("Initialized Time");

            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            //Simulate time passing by
            executorService.scheduleAtFixedRate(() -> {
                date = date.plusDays(1);
                Logger.TIME.log("It's now " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) + ".");
            }, 0, 5, TimeUnit.SECONDS);

            //Check if any room's lease has expired and if so, take appropriate actions
            executorService.scheduleAtFixedRate(Room::checkLeaseExpireAll, 10, 10, TimeUnit.SECONDS);
        }
    }

    public static boolean isInitialized() {
        return initialized;
    }

    public static LocalDate getDate() {
        return date;
    }
}
