package exercise.ex03.ex02;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Season> seasons = new ArrayList<>(Arrays.asList(Season.SPRING, Season.SUMMER, Season.AUTUMN, Season.WINTER));
        System.out.println(seasons.size());
        seasons.forEach(System.out::println);
    }
}
