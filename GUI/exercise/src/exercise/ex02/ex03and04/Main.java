package exercise.ex02.ex03and04;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Square[] squares = new Square[5];
        squares[0] = new Square(5);
        squares[1] = new Square(3);
        squares[2] = new Square(4);
        squares[3] = new Square(1);
        squares[4] = new Square(2);
        for (Square square : squares) {
            System.out.println(square);
        }

        System.out.println();
        Arrays.sort(squares);
        for (Square square : squares) {
            System.out.println(square);
        }
    }
}
