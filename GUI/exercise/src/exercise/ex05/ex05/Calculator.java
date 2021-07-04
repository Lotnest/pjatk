package exercise.ex05.ex05;

import exercise.ex05.ex05.operation.*;

import java.util.HashMap;

public class Calculator implements Operable {

    public String calculate(String expression) {
        HashMap<String, Operable> operationMap = new HashMap<>();
        operationMap.put("+", new Add());
        operationMap.put("-", new Subtract());
        operationMap.put("*", new Multiply());
        operationMap.put("/", new Divide());
        try {
            return operationMap.get(expression.split(" ")[1]).calculate(expression);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Unrecognized arithmetic operation");
        }
    }
}
