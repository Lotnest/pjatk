package exercise.ex02.ex02;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Singer s1 = new Singer("Eminem") {
            @Override
            public String sing() {
                return "You own it, you better never let it";
            }
        };
        Singer s2 = new Singer("Eagles") {
            @Override
            public String sing() {
                return "Hotel California";
            }
        };
        Singer s3 = new Singer("Dżem") {
            @Override
            public String sing() {
                return "Chwila, która trwa może być najlepszą z Twoich chwil...";
            }
        };

        Singer[] singers = {s1, s2, s3};
        Arrays.stream(singers)
                .forEach(System.out::println);
        System.out.println("\n" + Singer.loudest(singers));
    }
}
