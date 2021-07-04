package exercise.ex02.ex03and04;

public class Square implements Figure, Comparable<Square> {

    private final Integer length;

    public Square(Integer length) {
        if (length > max) {
            try {
                throw new TooBigSquareException("Maximum length is " + max);
            } catch (TooBigSquareException e) {
                e.printStackTrace();
            }
        }
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }

    @Override
    public int getArea() {
        return length ^ 2;
    }

    @Override
    public int getPerimeter() {
        return length * 4;
    }

    @Override
    public int compareTo(Square square) {
        if (this.equals(square)) {
            return 0;
        } else if (this.length > square.length) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Square{" +
                "length=" + length +
                '}';
    }
}
