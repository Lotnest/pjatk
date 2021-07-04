package exercise.ex11;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/cwiczenia/program11/Test.java"));
            Scanner scanner2 = new Scanner(new File("src/cwiczenia/program11/keyWords.txt"));
            ArrayList<String> keyWords = new ArrayList<>();
            while (scanner2.hasNext()) {
                keyWords.add(scanner2.next());
            }
            HashMap<String, Integer> count = new HashMap<>();
            String word = "";
            while ((word = scanner.next()) != null) {
                if (!count.containsKey(word)) {
                    count.put(word, 1);
                } else {
                    count.put(word, count.get(word) + 1);
                }
            }
            count.keySet().removeIf(string -> !keyWords.contains(string));
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
