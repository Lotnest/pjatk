package exercise.ex05.ex03;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> monthMap = new HashMap<>();
        monthMap.put("January", 31);
        monthMap.put("February", 28);
        monthMap.put("March", 31);
        monthMap.put("April", 30);
        monthMap.put("May", 31);
        monthMap.put("June", 30);
        monthMap.put("July", 31);
        monthMap.put("August", 31);
        monthMap.put("September", 30);
        monthMap.put("October", 31);
        monthMap.put("Novemember", 30);
        monthMap.put("December", 31);
        System.out.println(monthMap.get("March"));
        System.out.println(monthMap);
    }
}
