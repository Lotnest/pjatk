package exercise.ex04;

import java.security.SecureRandom;

public class Main {

    public static void main(String[] args) {
        exercise01();
        exercise02();
        exercise03();
        exercise04();
        exercise05();
        exercise06(new SecureRandom().nextInt(10));
        exercise07();
    }

    static void exercise01() {
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }
    }

    static void exercise02() {
        int wrt = 5;
        for (int i = 1; i < 11; i++) {
            System.out.println(wrt * i);
        }
    }

    static void exercise03() {
        int i = 0;
        while (i < 0) {
            System.out.println(i);
            i++;
        }
        System.out.println();
        System.out.println("Pętla while sprawdza warunek przed wykonaniem iteracji, 0 nie jest drukowane na ekranie.");
        System.out.println();
        int j = 0;
        do {
            System.out.println(j);
            j++;
        } while (j < 0);
        System.out.println("Pętla do-while sprawdza warunek po wykonaniu iteracji, dzięki czemu pętla wykonanie się co najmniej raz, a 0 jest drukowane na ekranie.");
    }

    static void exercise04() {
        double pow = 1;
        double sum = 0.0;
        for (int i = 0; i < 10; i++) {
            pow /= 2;
            sum += pow;
            System.out.println(sum);
        }
    }

    static void exercise05() {
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 5; j++) {
                    System.out.print("* ");
                    if (j == 4) {
                        System.out.println();
                    }
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    System.out.print(" *");
                    if (j == 3) {
                        System.out.println();
                    }
                }
            }
        }
    }

    static void exercise06(int size) {
        int starSize = 2 * size + 1;
        for (int i = 0; i < starSize; i++) {
            for (int j = 0; j < starSize; j++) {
                if (j >= i + size && i + size >= j && i + j >= starSize / 2 && i + j < starSize * 3 / 2) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }

    static void exercise07() {
        int min = 0;
        char[] chars = {'a', 'b', '.'};
        System.out.println((int) chars[0] + " " + (int) chars[1] + " " + (int) chars[2]);
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > min) {
                min = chars[i];
            }
        }
        System.out.println(min);
    }
}
