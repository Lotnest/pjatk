package exercise.ex03;

public class Main {

    public static void main(String[] args) {
        //I - 1327
        int binary = 0b10100101111;
        int octal = 02457;
        int hex = 0x52F;
        System.out.println(binary);
        System.out.println(octal);
        System.out.println(hex);

        //II
        System.out.println(0b1100 & 0b1000);

        //III
        byte b = 0xD;
        if ((b & 1) == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if ((b & 1) == 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
