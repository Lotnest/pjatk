package exercise.ex05.ex05;

public class Main {

    public static void main(String[] args) {
        //Calculator with no if, switches etc. expressions
        Calculator calculator = new Calculator();
        String result = calculator.calculate("2 * 3");
        String result2 = calculator.calculate("2 + 3");
        String result3 = calculator.calculate("2 - 3");
        String result4 = calculator.calculate("6 / 3");
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
