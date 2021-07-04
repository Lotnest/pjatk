package two.view;

public class MemoryCardView {

    private int size = 24, columns = 6, rows = 4;
    private double imageWidth = 90, imageHeight = 130;

    public int getSize() {
        return size;
    }

    public void setSize(final int size) {
        this.size = size;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(final int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(final int rows) {
        this.rows = rows;
    }

    public double getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(final double imageWidth) {
        this.imageWidth = imageWidth;
    }

    public double getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(final double imageHeight) {
        this.imageHeight = imageHeight;
    }
}
