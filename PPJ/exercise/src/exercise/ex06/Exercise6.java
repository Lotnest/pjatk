package exercise.ex06;

import java.security.SecureRandom;

public class Exercise6 {

    public static void main(String[] args) {
        exercise04();
        exercise05();
        exercise09();
    }

    static void exercise04() {
        int[][] tab = {
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1}
        };
        int size = 0;
        for (int i = 0; i < tab.length; i++) {
            size += i;
        }
        int[] result = new int[size];
        int index = 0;
        for (int[] ints : tab) {
            for (int i : ints) {
                result[index++] = i;
            }
        }
        for (int i : result) {
            System.out.print(i);
        }
    }

    static void exercise05() {
        int[] ints = new int[new SecureRandom().nextInt(10) + 1];
        int[] ints2 = new int[new SecureRandom().nextInt(10) + 1];
        int[] ints3 = new int[new SecureRandom().nextInt(10) + 1];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = new SecureRandom().nextInt(100);
        }
        for (int i = 0; i < ints2.length; i++) {
            ints2[i] = new SecureRandom().nextInt(100);
        }
        for (int i = 0; i < ints3.length; i++) {
            ints3[i] = new SecureRandom().nextInt(100);
        }
        int[][] result = new int[3][Math.max(Math.max(ints.length, ints2.length), ints3.length)];
        result[0] = ints;
        result[1] = ints2;
        result[2] = ints3;
        for (int[] value : result) {
            for (int i : value) {
                System.out.print(i + " ");
            }
            System.out.print("| ");
        }
    }

    static void exercise09() {
        int wrt = 5;
        System.out.println(wrt);
        modifyValue(wrt);
        System.out.println(wrt);
    }

    static void modifyValue(int x) {
        System.out.println(x);
        x *= 5;
        System.out.println(x);
    }
}