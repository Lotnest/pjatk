package exercise.ex05.ex01;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(
                "Ala",
                "ma",
                "Kota",
                "a",
                "Cat",
                "ma",
                "Ale"
        ));
        System.out.println(stringList.size());
        System.out.println(stringList);
        stringList.stream().map(String::toLowerCase)
                .forEach(string -> {
                    if (string.endsWith("a")) {
                        System.out.println(string);
                    }
                });
    }
}
