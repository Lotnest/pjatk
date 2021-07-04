package exercise.ex10;

public class FruitTree extends LeafyTree {

    private final String fruitName;

    public FruitTree(boolean foreverGreen, int height, String treeCrossSection, int leafShape, String fruitName) {
        super(foreverGreen, height, treeCrossSection, leafShape);
        this.fruitName = fruitName;
    }

    @Override
    public String toString() {
        return "FruitTree{" +
                "fruitName='" + fruitName + '\'' +
                '}';
    }
}
