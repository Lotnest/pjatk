package exercise.ex10;

public class LeafyTree extends Tree {

    private final int leafShape;

    public LeafyTree(boolean foreverGreen, int height, String treeCrossSection, int leafShape) {
        super(foreverGreen, height, treeCrossSection);
        this.leafShape = leafShape;
    }

    @Override
    public String toString() {
        return "LeafyTree{" +
                "leafShape=" + leafShape +
                '}';
    }
}
