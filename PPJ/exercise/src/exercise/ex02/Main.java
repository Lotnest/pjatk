package exercise.ex02;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //I, VI, VIII, IX, XI, XII

        //I
        byte b = 46;
        System.out.println((b & 1) == 1 ? "Bit zerowy to 1" : "Bit zerowy to 0");
        System.out.println((b >> 5 & 1) == 1 ? "Bit piąty to 1" : "Bit piąty to 0\n");

        //VI
        boolean boolean1 = true, boolean2 = true;
        System.out.println((boolean1 && !boolean2) || (boolean2 && !boolean1));
        boolean2 = false;
        System.out.println((boolean1 && !boolean2) || (boolean2 && !boolean1));
        boolean1 = false;
        boolean2 = true;
        System.out.println((boolean1 && !boolean2) || (boolean2 && !boolean1));
        boolean2 = false;
        System.out.println((boolean1 && !boolean2) || (boolean2 && !boolean1));
        System.out.println();

        //VIII
        Scanner in = new java.util.Scanner(System.in);
        System.out.println("Podaj swój numer studenta");
        int studentId = in.nextInt();
        System.out.println("Hello s" + studentId + "\n");

        //IX
        double leftOver = 10 % 3;
        System.out.println(leftOver + "\n");

        //XI
        boolean czyPada = true, czySwieciSlonce = false;

        //plucha – gdy pada i nie świeci słońce
        //tęcza – gdy pada i świeci słońce
        //słonecznie - gdy świeci słońce i nie pada
        //pochmurno - gdy nie świeci słońce i nie pada
        if (czyPada && !czySwieciSlonce) {
            System.out.println("plucha");
        } else if (czyPada && czySwieciSlonce) {
            System.out.println("tęcza");
        } else if (!czyPada && czySwieciSlonce) {
            System.out.println("słonecznie");
        } else {
            System.out.println("pochmurno\n");
        }

        //XII
        //Dana jest zmienna typu boolean czyPada oraz zmienna typu boolean czySwieciSlonce,
        //obie zainicjowane losową wartością. Przyjmij że jeżeli wylosowana wartość będzie mniejsza niż 0.
        //wówczas przypisana zostanie wartość true, a w przeciwnym przypadku false.
        //Zadeklaruj zmienną typu byte, której:
        //•bit 0 (najmłodzy) będzie reprezentował stan zmiennej czyPada
        //•bit 1 będzie reprezentował stan zmiennej czySwieciSlonce
        //Następnie wykorzystaj instrukcję switch, aby dokonać takiej samej klasyfikacji jakw pierwszej części zadania.
        double d = new SecureRandom().nextDouble();
        boolean czyPada1 = d < 0.5, czySwieciSlonce1 = d < 0.5;
        byte b1 = 80;
        czyPada1 = (b1 & 1) == 1 ? true : false;
        czySwieciSlonce1 = (b1 << 1 & 1) == 1 ? true : false;
    }
}
