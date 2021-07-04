package exercise.ex05;

public class Exercise5 {

    public static void main(String[] args) {
        exercise01(15151);
        exercise02(2);
        exercise03();
    }

    static void exercise01(int studentIndex) {
        int[] ints = getDigitsAsArray(studentIndex, count(studentIndex));
        if (ints.length != 5) {
            System.out.println("Numer studencki musi mieć 5 cyfr.");
            return;
        }
        int sum = 0;
        for (int i : ints) {
            sum += i;
        }
        System.out.println(sum);
    }

    static void exercise02(int n) {
        System.out.println(fibonacci(n));
    }

    static void exercise03() {
        int[] arr = {153, 333, 370, 515, 407, 80};
        for (int num : arr) {
            System.out.println(isNarcisstic(num));
        }
    }

    static int[] getDigitsAsArray(int num, int arrayLength) {
        int[] digits = new int[arrayLength];
        int i = 0;
        while (num > 0) {
            digits[i] = num % 10;
            num /= 10;
            i++;
        }
        return digits;
    }

    static int count(int num) {
        if (num == 0) return 1;
        int digits = 0;
        while (num > 0) {
            num /= 10;
            digits++;
        }
        return digits;
    }

    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static boolean isNarcisstic(int num) {
        int a = countNarcisstic(num);
        int b = num;
        int sum = 0;
        while (b > 0) {
            sum += (b % 10) ^ a;
            b /= 10;
        }
        return num == sum;
    }

    static int countNarcisstic(int n) {
        if (n == 0) {
            return 0;
        }
        return 1 + countNarcisstic(n / 10);
    }
}
