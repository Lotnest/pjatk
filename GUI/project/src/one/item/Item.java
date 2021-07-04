package one.item;

import one.estate.room.Area;
import one.util.Content;

public enum Item implements Content {

    BOX("Box", new Area(0.4, 0.3, 0.3));

    private final String name;
    private final Area area;

    Item(final String name, final Area area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public Area getArea() {
        return area;
    }
}
