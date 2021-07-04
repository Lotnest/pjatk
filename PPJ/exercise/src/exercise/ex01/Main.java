package exercise.ex01;

public class Main {

    public static void main(String[] args) {
        System.out.println("=====Zadanie 1=====");
        System.out.println("Witaj PPJ");

        boolean v = true;
        byte b = 2;
        short s = 10;
        double d = 10.11;
        float f = 8.2f;
        int c = '~';

        int iSzesnastkowy = 0x8A;
        long lSzesnastkowy = 0xCD;
        int iDziesietny = 123;
        long lDziesietny = 23894;
        int iOsemkowy = 010;
        long lOsemkowy = 023;
        int iBinarny = 0b0110;
        long lBinarny = 0b11010;

        System.out.println("=====Zadanie 2=====");
        System.out.println(v);
        System.out.println(b);
        System.out.println(s);
        System.out.println(d);
        System.out.println(f);
        System.out.println(c);
        System.out.println(iSzesnastkowy);
        System.out.println(lSzesnastkowy);
        System.out.println(iDziesietny);
        System.out.println(lDziesietny);
        System.out.println(iOsemkowy);
        System.out.println(lOsemkowy);
        System.out.println(iBinarny);
        System.out.println(lBinarny);

        System.out.println("=====Zadanie 3=====");
        //128(DEC)
        //binarny
        int dec128_1 = 0b10000000;
        System.out.println(dec128_1);
        //oktalny
        int dec128_2 = 0200;
        System.out.println(dec128_2);
        //szesnastkowy
        int dec128_3 = 0x80;
        System.out.println(dec128_3);

        //2314(OCT)
        //dziesiętny
        int oct2314_1 = 1228;
        System.out.println(oct2314_1);
        //binarny
        int oct2314_2 = 0b10011001100;
        System.out.println(oct2314_2);
        //szesnastkowy
        int oct2314_3 = 0x4CC;
        System.out.println(oct2314_3);

        //AD7(HEX)
        //dziesiętny
        int ad7_1 = 2775;
        System.out.println(ad7_1);
        //binarny
        int ad7_2 = 0b101011010111;
        System.out.println(ad7_2);
        //oktalny
        int ad7_3 = 05327;
        System.out.println(ad7_3);

        System.out.println("=====Zadanie 4=====");
        int num1 = 8;
        int num2 = 14;
        System.out.println(num1 | num2);
        System.out.println(num1 & num2);
        System.out.println(num1 << num2);
        System.out.println(num1 >> num2);
    }
}
