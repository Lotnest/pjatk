package exercise.ex10;

public class ConiferousTree extends Tree {

    private final int needlesAmount;
    private final double coneLength;

    public ConiferousTree(boolean foreverGreen, int height, String treeCrossSection, int needlesAmount, double coneLength) {
        super(foreverGreen, height, treeCrossSection);
        this.needlesAmount = needlesAmount;
        this.coneLength = coneLength;
    }

    @Override
    public String toString() {
        return "ConiferousTree{" +
                "needlesAmount=" + needlesAmount +
                ", coneLength=" + coneLength +
                '}';
    }
}
