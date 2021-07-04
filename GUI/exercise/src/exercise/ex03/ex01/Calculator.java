package exercise.ex03.ex01;

public class Calculator <T extends Number> {

    private final T t1;
    private final T t2;

    public Calculator(T t1, T t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public static void main(String[] args) {
        Calculator<Float> floatCalculator = new Calculator<>(17F, 25F);
        Calculator<Integer> integerCalculator = new Calculator<>(123, 65);
        floatCalculator.calculate();
        integerCalculator.calculate();
    }

    public void calculate() {
        System.out.println(t1.doubleValue() * t2.doubleValue());
    }
}
