package exercise.ex05.ex05.operation;

public class Subtract implements Operable {

    public String calculate(String expression) {
        String[] parts = expression.split(" ");
        return String.valueOf(Integer.parseInt(parts[0]) - Integer.parseInt(parts[2]));
    }
}
