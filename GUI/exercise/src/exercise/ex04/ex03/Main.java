package exercise.ex04.ex03;

import exercise.ex04.ex02.ICalc;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        ArrayList<Double> randomDoubles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomDoubles.add(ThreadLocalRandom.current().nextDouble(1D, 100D));
        }
        calculate(randomDoubles, Double::sum);
    }

    public static ArrayList<Double> calculate(ArrayList<Double> doubleList, ICalc iCalc) {
        ArrayList<Double> calculatedIntegers = new ArrayList<>();
        for (int i = 0; i < doubleList.size() - 1; i++) {
            calculatedIntegers.add(iCalc.calculate(doubleList.get(i), doubleList.get(i + 1)));
        }
        System.out.println(doubleList);
        System.out.println(calculatedIntegers);
        return calculatedIntegers;
    }
}
