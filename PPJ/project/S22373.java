package cwiczenia.projekt;

import java.io.*;
import java.security.SecureRandom;
import java.util.Scanner;

public class S22373 {

    public static void main(String[] args) {
        initialize();
    }

    public static void initialize() {
        Container[] containers = new Container[15000];
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Containers.txt"));
            bufferedWriter.append("container\tid\tweight\tmaxWeight\ttotalWeight\tlength\twidth\theight\titemTransported\n\n");
            for (int i = 0; i < containers.length; i++) {
                // Get a random ContainerCategory with each incremental
                ContainerCategory randomContainerCategory = ContainerCategory.random();
                /*
                Switch over random ContainerCategory, initialize an appropriate class for it,
                assign a unique identifier and make it transport a random Item suited for that category
                */
                switch (randomContainerCategory) {
                    case DV:
                        DV20Container dv20Container = new DV20Container(i, Item.getRandomItemByCategory(randomContainerCategory));
                        System.out.println("WRITE:" + dv20Container);
                        bufferedWriter.append(dv20Container.toFileString());
                        bufferedWriter.newLine();
                        break;
                    case REEFER:
                        Reefer20Container reefer20Container = new Reefer20Container(i, Item.getRandomItemByCategory(randomContainerCategory));
                        System.out.println("WRITE:" + reefer20Container);
                        bufferedWriter.append(reefer20Container.toFileString());
                        bufferedWriter.newLine();
                        break;
                    case TANK:
                        Tank20Container tank20Container = new Tank20Container(i, Item.getRandomItemByCategory(randomContainerCategory));
                        System.out.println("WRITE:" + tank20Container);
                        bufferedWriter.append(tank20Container.toFileString());
                        bufferedWriter.newLine();
                        break;
                    case HARD_TOP:
                        HardTop20Container hardTop20Container = new HardTop20Container(i, Item.getRandomItemByCategory(randomContainerCategory));
                        System.out.println("WRITE:" + hardTop20Container);
                        bufferedWriter.append(hardTop20Container.toFileString());
                        bufferedWriter.newLine();
                        break;
                    case HC:
                        HC40Container hc40Container = new HC40Container(i, Item.getRandomItemByCategory(randomContainerCategory));
                        System.out.println("WRITE:" + hc40Container);
                        bufferedWriter.append(hc40Container.toFileString());
                        bufferedWriter.newLine();
                        break;
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Scanner scanner = new Scanner(new File("Containers.txt"));
            String line = "";
            for (int i = 0; i < 3; i++) {
                line = scanner.nextLine();
            }
            for (int i = 0; i < 15000; i++) {
                String[] split = line.split("\t");
                String container = split[0];
                switch (container) {
                    case "DV20Container":
                        DV20Container dv20Container = new DV20Container(Integer.valueOf(split[1]), Item.parseItem(split[8]));
                        dv20Container.setTotalWeight(Double.valueOf(split[4]));
                        containers[dv20Container.getId()] = dv20Container;
                        break;
                    case "Reefer20Container":
                        Reefer20Container reefer20Container = new Reefer20Container(Integer.valueOf(split[1]), Item.parseItem(split[8]));
                        reefer20Container.setTotalWeight(Double.valueOf(split[4]));
                        containers[reefer20Container.getId()] = reefer20Container;
                        break;
                    case "Tank20Container":
                        Tank20Container tank20Container = new Tank20Container(Integer.valueOf(split[1]), Item.parseItem(split[8]));
                        tank20Container.setTotalWeight(Double.valueOf(split[4]));
                        containers[tank20Container.getId()] = tank20Container;
                        break;
                    case "HardTop20Container":
                        HardTop20Container hardTop20Container = new HardTop20Container(Integer.valueOf(split[1]), Item.parseItem(split[8]));
                        hardTop20Container.setTotalWeight(Double.valueOf(split[4]));
                        containers[hardTop20Container.getId()] = hardTop20Container;
                        break;
                    case "HC40Container":
                        HC40Container hc40Container = new HC40Container(Integer.valueOf(split[1]), Item.parseItem(split[8]));
                        hc40Container.setTotalWeight(Double.valueOf(split[4]));
                        containers[hc40Container.getId()] = hc40Container;
                        break;
                    default:
                        try {
                            throw new InvalidContainerException("Container named \"" + container + "\" was not found.");
                        } catch (InvalidContainerException e) {
                            e.printStackTrace();
                        }
                        break;
                }
                System.out.println("READ: " + containers[i]);
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                }
            }
            Container.sort(containers);
            // System.out.println("\nTHE HEAVIEST: " + containers[0] + "\nTHE LIGHTEST: " + containers[14999]);
            ContainerShip containerShip = new ContainerShip(73, 14);
            containerShip.placeContainers(containers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    abstract static class Container {

        private Integer id;
        private Integer weight;
        private Integer maxWeight;
        private Double totalWeight;
        private Double length;
        private Double width;
        private Double height;
        private Item itemTransported;

        public Container(Integer id, Integer weight, Integer maxWeight, Double totalWeight, Double length, Double width, Double height, Item itemTransported) {
            this.id = id;
            this.weight = weight;
            this.maxWeight = maxWeight;
            this.totalWeight = totalWeight;
            this.length = length;
            this.width = width;
            this.height = height;
            this.itemTransported = itemTransported;
        }

        public static void sort(Container[] containers) {
            int length = containers.length;
            Container temp;
            // Bubble sort
            for (int i = 0; i < length; i++) {
                for (int j = 1; j < length - i; j++) {
                    if (containers[j - 1].totalWeight < containers[j].totalWeight) {
                        temp = containers[j - 1];
                        containers[j - 1] = containers[j];
                        containers[j] = temp;
                    }
                }
            }
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public Integer getMaxWeight() {
            return maxWeight;
        }

        public void setMaxWeight(Integer maxWeight) {
            this.maxWeight = maxWeight;
        }

        public Double getTotalWeight() {
            return totalWeight;
        }

        public void setTotalWeight(Double totalWeight) {
            checkWeight(totalWeight);
            this.totalWeight = totalWeight;
        }

        public Double getLength() {
            return length;
        }

        public void setLength(Double length) {
            this.length = length;
        }

        public Double getWidth() {
            return width;
        }

        public void setWidth(Double width) {
            this.width = width;
        }

        public Double getHeight() {
            return height;
        }

        public void setHeight(Double height) {
            this.height = height;
        }

        public Item getItemTransported() {
            return itemTransported;
        }

        public void setItemTransported(Item itemTransported) {
            this.itemTransported = itemTransported;
        }

        public void checkWeight(Double totalWeight) {
            if (totalWeight > getMaxWeight()) {
                try {
                    throw new InvalidWeightException("Total weight is bigger than the maximum weight (" + totalWeight + " > " + getMaxWeight() + ")");
                } catch (InvalidWeightException e) {
                    e.printStackTrace();
                }
            } else if (totalWeight < getWeight()) {
                try {
                    throw new InvalidWeightException("Total weight is smaller than the container weight (" + totalWeight + " > " + getWeight() + ")");
                } catch (InvalidWeightException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String toString() {
            return "Container{" +
                    "id=" + getId() +
                    ", weight=" + getWeight() +
                    ", maxWeight=" + getMaxWeight() +
                    ", length=" + getLength() +
                    ", width=" + getWidth() +
                    ", height=" + getHeight() +
                    ", itemTransported=" + getItemTransported().getName() +
                    '}';
        }

        public String toFileString() {
            return "Container\t" + getId() + "\t" + getWeight() + "\t" + getMaxWeight() + "\t" + getLength() + "\t" + getWidth() + "\t" + getHeight() + "\t" + getItemTransported().getName();
        }
    }

    /*
    DV `20

    Weight: 2370 kg
    Max weight: 28230 kg
    Length: 5,9 m
    Width: 2,35 m
    Height: 2,395 m
    */
    static class DV20Container extends Container {

        public DV20Container(Integer id, Item itemTransported) {
            super(id, 2370, 28230, 2370.0, 5.9, 2.35, 2.395, itemTransported);
            // Limit to three decimal points
            String format = String.format("%.03f", getWeight() + (getMaxWeight() - getWeight()) * Math.random());
            // Convert it back to Double
            setTotalWeight(Double.valueOf(format.replace(',', '.')));
        }

        @Override
        public String toString() {
            return "DV20Container{" +
                    "id=" + getId() +
                    ", weight=" + getWeight() +
                    ", maxWeight=" + getMaxWeight() +
                    ", totalWeight=" + getTotalWeight() +
                    ", length=" + getLength() +
                    ", width=" + getWidth() +
                    ", height=" + getHeight() +
                    ", itemTransported=" + getItemTransported().getName() +
                    '}';
        }

        public String toFileString() {
            return "DV20Container\t" + getId() + "\t" + getWeight() + "\t" + getMaxWeight() + "\t" + getTotalWeight() + "\t" + getLength() + "\t" + getWidth() + "\t" + getHeight() + "\t" + getItemTransported().getName();
        }
    }

    /*
    Reefer 20`

    Weight: 2905 kg
    Max weight: 27420 kg
    Length: 5,535 m
    Width: 2,284 m
    Height: 2,224 m
    */
    static class Reefer20Container extends Container {

        public Reefer20Container(Integer id, Item itemTransported) {
            super(id, 2905, 27420, 2905.0, 5.535, 2.284, 2.224, itemTransported);
            // Limit to three decimal points
            String format = String.format("%.03f", getWeight() + (getMaxWeight() - getWeight()) * Math.random());
            // Convert it back to Double
            setTotalWeight(Double.valueOf(format.replace(',', '.')));
        }

        @Override
        public String toString() {
            return "Reefer20Container{" +
                    "id=" + getId() +
                    ", weight=" + getWeight() +
                    ", maxWeight=" + getMaxWeight() +
                    ", totalWeight=" + getTotalWeight() +
                    ", length=" + getLength() +
                    ", width=" + getWidth() +
                    ", height=" + getHeight() +
                    ", itemTransported=" + getItemTransported().getName() +
                    '}';
        }

        public String toFileString() {
            return "Reefer20Container\t" + getId() + "\t" + getWeight() + "\t" + getMaxWeight() + "\t" + getTotalWeight() + "\t" + getLength() + "\t" + getWidth() + "\t" + getHeight() + "\t" + getItemTransported().getName();
        }
    }

    /*
    Tank 20`

    Weight: 3385 kg
    Max weight: 32580 kg
    Length: 6,058 m
    Width: 2,438 m
    Height: 2,591 m
    */
    static class Tank20Container extends Container {

        public Tank20Container(Integer id, Item itemTransported) {
            super(id, 3385, 32580, 3385.0, 6.058, 2.438, 2.591, itemTransported);
            // Limit to three decimal points
            String format = String.format("%.03f", getWeight() + (getMaxWeight() - getWeight()) * Math.random());
            // Convert it back to Double
            setTotalWeight(Double.valueOf(format.replace(',', '.')));
        }

        @Override
        public String toString() {
            return "Tank20Container{" +
                    "id=" + getId() +
                    ", weight=" + getWeight() +
                    ", maxWeight=" + getMaxWeight() +
                    ", totalWeight=" + getTotalWeight() +
                    ", length=" + getLength() +
                    ", width=" + getWidth() +
                    ", height=" + getHeight() +
                    ", itemTransported=" + getItemTransported().getName() +
                    '}';
        }

        public String toFileString() {
            return "Tank20Container\t" + getId() + "\t" + getWeight() + "\t" + getMaxWeight() + "\t" + getTotalWeight() + "\t" + getLength() + "\t" + getWidth() + "\t" + getHeight() + "\t" + getItemTransported().getName();
        }
    }

    /*
    Hard Top 20`

    Weight: 2590 kg
    Max weight: 27780 kg
    Length: 5,886 m
    Width: 2,342 m
    Height: 2,375 m
    */
    static class HardTop20Container extends Container {

        public Double totalWeight;

        public HardTop20Container(Integer id, Item itemTransported) {
            super(id, 2590, 27780, 2590.0, 5.886, 2.342, 2.375, itemTransported);
            // Limit to three decimal points
            String format = String.format("%.03f", getWeight() + (getMaxWeight() - getWeight()) * Math.random());
            // Convert it back to Double
            setTotalWeight(Double.valueOf(format.replace(',', '.')));
        }

        @Override
        public String toString() {
            return "HardTop20Container{" +
                    "id=" + getId() +
                    ", weight=" + getWeight() +
                    ", maxWeight=" + getMaxWeight() +
                    ", totalWeight=" + getTotalWeight() +
                    ", length=" + getLength() +
                    ", width=" + getWidth() +
                    ", height=" + getHeight() +
                    ", itemTransported=" + getItemTransported().getName() +
                    '}';
        }

        public String toFileString() {
            return "HardTop20Container\t" + getId() + "\t" + getWeight() + "\t" + getMaxWeight() + "\t" + getTotalWeight() + "\t" + getLength() + "\t" + getWidth() + "\t" + getHeight() + "\t" + getItemTransported().getName();
        }
    }

    /*
    HC 40`

    Weight: 4010 kg
    Max weight: 28490 kg
    Length: 12,032 m
    Width: 2,35 m
    Height: 2,7 m
    */
    static class HC40Container extends Container {

        public HC40Container(Integer id, Item itemTransported) {
            super(id, 4010, 28490, 4010.0, 12.032, 2.35, 2.7, itemTransported);
            // Limit to three decimal points
            String format = String.format("%.03f", getWeight() + (getMaxWeight() - getWeight()) * Math.random());
            // Convert it back to Double
            setTotalWeight(Double.valueOf(format.replace(',', '.')));
        }

        @Override
        public String toString() {
            return "HC40Container{" +
                    "id=" + getId() +
                    ", weight=" + getWeight() +
                    ", maxWeight=" + getMaxWeight() +
                    ", totalWeight=" + getTotalWeight() +
                    ", length=" + getLength() +
                    ", width=" + getWidth() +
                    ", height=" + getHeight() +
                    ", itemTransported=" + getItemTransported().getName() +
                    '}';
        }

        public String toFileString() {
            return "HC40Container\t" + getId() + "\t" + getWeight() + "\t" + getMaxWeight() + "\t" + getTotalWeight() + "\t" + getLength() + "\t" + getWidth() + "\t" + getHeight() + "\t" + getItemTransported().getName();
        }
    }

    enum Item {

        // DV
        HEADPHONES("Headphones", ContainerCategory.DV),
        TV("TV", ContainerCategory.DV),
        CLEANING_AGENT("Cleaning agent", ContainerCategory.DV),
        SHAMPOO("Shampoo", ContainerCategory.DV),

        // Reefer
        STEAK("Steak", ContainerCategory.REEFER),
        FRIES("Fries", ContainerCategory.REEFER),
        ICE_CREAM("Ice Cream", ContainerCategory.REEFER),
        PIZZA("Pizza", ContainerCategory.REEFER),

        // Hard Top
        BICYCLE("Bicycle", ContainerCategory.HARD_TOP),
        LAPTOP("Laptop", ContainerCategory.HARD_TOP),
        PAINTING("Painting", ContainerCategory.HARD_TOP),
        DESK("Desk", ContainerCategory.HARD_TOP),

        // Tank
        WATER("Water", ContainerCategory.TANK),
        OIL("Oil", ContainerCategory.TANK),
        APPLE_JUICE("Apple juice", ContainerCategory.TANK),
        MILK("Milk", ContainerCategory.TANK),

        // HC
        BED("Bed", ContainerCategory.HC),
        LAMP("Lamp", ContainerCategory.HC),
        FLOWER_POT("Flower pot", ContainerCategory.HC),
        JEANS("Jeans", ContainerCategory.HC);

        private final String name;
        private final ContainerCategory containerCategory;

        Item(String name, ContainerCategory containerCategory) {
            this.name = name;
            this.containerCategory = containerCategory;
        }

        public static Item random() {
            Item[] items = Item.values();
            return items[new SecureRandom().nextInt(items.length)];
        }

        public static Item getRandomItemByCategory(ContainerCategory containerCategory) {
            // Get an array of all items
            Item[] items = Item.values();
            SecureRandom random = new SecureRandom();
            // Shuffle the array
            for (int i = 0; i < items.length; i++) {
                int randomIndex = random.nextInt(items.length);
                Item temp = items[i];
                items[i] = items[randomIndex];
                items[randomIndex] = temp;
            }
            // Get the first item of shuffled array that matches the category and return it
            for (Item item : items) {
                if (item != null && item.containerCategory == containerCategory) return item;
            }
            // Return random item otherwise, to avoid method being nullable
            return items[random.nextInt(items.length)];
        }

        public static Item parseItem(String name) {
            if (name != null) {
                return Item.valueOf(name.toUpperCase().replaceAll(" ", "_"));
            }
            return Item.random();
        }

        public String getName() {
            return name;
        }

        public ContainerCategory getContainerCategory() {
            return containerCategory;
        }
    }

    enum ContainerCategory {

        DV,
        REEFER,
        TANK,
        HARD_TOP,
        HC;

        public static ContainerCategory random() {
            ContainerCategory[] containerCategories = ContainerCategory.values();
            return containerCategories[new SecureRandom().nextInt(containerCategories.length)];
        }
    }

    static class InvalidWeightException extends Exception {

        public InvalidWeightException(String text) {
            super(text);
        }
    }

    static class InvalidContainerException extends Exception {

        public InvalidContainerException(String text) {
            super(text);
        }
    }

    static class ContainerShip {

        private final Integer maxBays;
        private final Integer maxRows;

        public ContainerShip(Integer maxBays, Integer maxRows) {
            this.maxBays = maxBays;
            this.maxRows = maxRows;
        }

        public Integer getMaxBays() {
            return maxBays;
        }

        public Integer getMaxRows() {
            return maxRows;
        }

        public void placeContainers(Container[] containers) {
            boolean b = true;
            int row = 0;
            int bay = 1;
            int tier = 0;
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Manifest.txt"));
                bufferedWriter.append("id\tposition\ttotalWeight\titemTransported\n\n");
                for (Container container : containers) {
                    String rowString = String.valueOf(row);
                    String bayString = String.valueOf(bay);
                    String tierString = String.valueOf(tier);
                    if (row < 10) {
                        rowString = "0" + row;
                    }
                    if (bay < 10) {
                        bayString = "0" + bay;
                    }
                    if (tier < 10) {
                        tierString = "0" + tier;
                    }
                    String appendedText = container.getId() + "\t" + bayString + rowString + tierString + "\t" + container.getTotalWeight() + "\t" + container.getItemTransported().getName();
                    System.out.println("WRITE: " + appendedText);
                    bufferedWriter.append(appendedText);
                    bufferedWriter.newLine();
                    row++;
                    if (maxRows < row) {
                        row = 0;
                        if (b) {
                            bay += 2;
                            if (maxBays < bay) {
                                bay = getMaxBays();
                                tier++;
                                b = false;
                            }
                        } else {
                            bay -= 2;
                            if (bay < 0) {
                                bay = 1;
                                tier += 2;
                                b = false;
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
