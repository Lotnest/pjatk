package exercise.ex04.ex02;

public class Main {

    public static void main(String[] args) {
        ICalc add = Double::sum;
        System.out.println(add.calculate(5D, 33D));

        ICalc subtract = (d1, d2) -> d1 - d2;
        System.out.println(subtract.calculate(100.23D, 12.25D));

        ICalc multiply = (d1, d2) -> d1 * d2;
        System.out.println(multiply.calculate(13D, 10.5D));

        ICalc divide = (d1, d2) -> d1 / d2;
        System.out.println(divide.calculate(1000D, 20D));
    }
}
