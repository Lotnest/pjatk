package one.estate;

import one.util.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class Developer {

    private String name;
    private ArrayList<Estate> estates;

    public Developer(final String name) {
        this.name = name;
        this.estates = new ArrayList<>();

        Logger.DEBUG.log("Initialized " + this);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public ArrayList<Estate> getEstates() {
        return estates;
    }

    public void setEstates(final ArrayList<Estate> estates) {
        this.estates = estates;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Developer developer = (Developer) o;
        return Objects.equals(name, developer.name) && Objects.equals(estates, developer.estates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, estates);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", estates=" + estates +
                '}';
    }
}
