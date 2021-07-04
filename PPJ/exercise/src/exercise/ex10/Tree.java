package exercise.ex10;

public class Tree {

    private final boolean foreverGreen;
    private final int height;
    private final String treeCrossSection;

    public Tree(boolean foreverGreen, int height, String treeCrossSection) {
        this.foreverGreen = foreverGreen;
        this.height = height;
        this.treeCrossSection = treeCrossSection;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "foreverGreen=" + foreverGreen +
                ", height=" + height +
                ", treeCrossSection='" + treeCrossSection + '\'' +
                '}';
    }

    public void zerwijOwoc() {
        if (!(this instanceof FruitTree)) {
            try {
                throw new TreeWithoutFruitsException("Tree with no fruits");
            } catch (TreeWithoutFruitsException e) {
                e.printStackTrace();
            }
        }
    }
}
