package exercise.ex05.ex02;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<Integer> integerSet = new HashSet<>(Arrays.asList(
                31,
                28,
                31,
                30,
                31,
                30,
                31,
                31,
                30,
                31,
                30,
                31
        ));
        System.out.println(integerSet);
    }
}
