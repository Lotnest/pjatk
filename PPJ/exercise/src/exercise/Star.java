package exercise;

import java.util.ArrayList;

public class Star {

    public static void main(String[] args) {
        for (int split = 0; split < 5; split++) {
            for (int lineIndex = 0; lineIndex < 10; lineIndex++) {
                if (lineIndex <= split) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
        for (int split = 0; split < 5; split++) {
            for (int lineIndex = 0; lineIndex < 10; lineIndex++) {
                if (lineIndex - 5 >= split) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    public static long[] getNotSelected(long[] data, int[] select) {
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (select[0] != data[0]) {
                list.add(data[0]);
            }
        }
        long[] array = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
