package one.estate.room;

import one.util.Logger;
import one.util.Validator;

import java.util.Comparator;
import java.util.Objects;

public class Area implements Comparable<Area> {

    private double x;
    private double y;
    private double z;
    private double volume;

    public Area(final double volume) {
        this.volume = Validator.validateVolume(volume);
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;

        Logger.DEBUG.log("Initialized " + this);
    }

    public Area(final double x, final double y, final double z) {
        this.x = Validator.validateLength(x);
        this.y = Validator.validateLength(y);
        this.z = Validator.validateLength(z);
        this.volume = x * y * z;

        Logger.DEBUG.log("Initialized " + this);
    }

    public double getX() {
        return x;
    }

    public void setX(final double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(final double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(final double z) {
        this.z = z;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(final double volume) {
        this.volume = volume;
    }

    public Area add(final double x, final double y, final double z) {
        this.x += Validator.validateLength(x);
        this.y += Validator.validateLength(y);
        this.z += Validator.validateLength(z);
        this.volume = x * y * z;
        return this;
    }

    public Area add(final Area area) {
        return add(area.getX(), area.getY(), area.getZ());
    }

    public Area subtract(final double x, final double y, final double z) {
        this.x -= Validator.validateLength(x);
        this.y -= Validator.validateLength(y);
        this.z -= Validator.validateLength(z);
        this.volume = Validator.validateVolume(x * y * z);
        return this;
    }

    public Area subtract(final Area area) {
        return subtract(area.getX(), area.getY(), area.getZ());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Area that = (Area) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0 && Double.compare(that.z, z) == 0 && Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, volume);
    }

    @Override
    public String toString() {
        return "Area{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", volume=" + volume +
                '}';
    }

    @Override
    public int compareTo(final Area area) {
        return Objects.compare(this, area, Comparator.comparingDouble(Area::getX)
                .thenComparingDouble(Area::getY)
                .thenComparingDouble(Area::getZ));
    }
}
