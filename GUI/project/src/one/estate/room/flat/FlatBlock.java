package one.estate.room.flat;

import one.estate.room.MiejsceParkingowe;
import one.util.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class FlatBlock {

    private final ArrayList<Mieszkanie> flats;
    private final ArrayList<MiejsceParkingowe> parkingSpots;

    public FlatBlock(final ArrayList<Mieszkanie> flats, final ArrayList<MiejsceParkingowe> parkingSpots) {
        this.flats = flats;
        this.parkingSpots = parkingSpots;

        Logger.DEBUG.log("Initialized " + this);
    }

    public ArrayList<Mieszkanie> getFlats() {
        return flats;
    }

    public ArrayList<MiejsceParkingowe> getParkingSpots() {
        return parkingSpots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatBlock flatBlock = (FlatBlock) o;
        return Objects.equals(flats, flatBlock.flats) && Objects.equals(parkingSpots, flatBlock.parkingSpots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flats, parkingSpots);
    }

    @Override
    public String toString() {
        return "FlatBlock{" +
                "flats=" + flats +
                ", parkingSpots=" + parkingSpots +
                '}';
    }
}
