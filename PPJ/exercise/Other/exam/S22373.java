package exercise.exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class S22373 {

    public static void main(String[] args) {
        PhoneValidator.check();
    }

    static class Person {

        private String name, lastName;

        public Person() {
            System.out.println("constr: Person()");
        }

        public Person(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        public void show() {
            System.out.println(name + " " + lastName);
        }
    }

    static class Point extends Object {

        protected int x, y;

        public Point() {
            System.out.println(this);
        }

        public Point(int x) {
            this(x, 0);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return super.toString() + " Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public boolean equals(Point point) {
            if (this == point) {
                return true;
            }
            return x == point.x && y == point.y;
        }
    }

    static class Point3D extends Point {

        protected int z;

        public Point3D(int z) {
            this(0, 0, z);
        }

        public Point3D(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Node {

        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", val=" + val +
                    '}';
        }
    }

    public static class MyList {

        Node head;

        public MyList() {
            head = null;
        }

        public void add(int val) {
            Node tmp = new Node(val);

            if (head == null)
                head = tmp;
            else {
                Node headDuplicate = head;

                while (headDuplicate.getNext() != null)
                    headDuplicate = headDuplicate.getNext();
                headDuplicate.setNext(tmp);
            }
        }

        public void insert(int index, int val) {
            Node node = new Node(val);
            if (head == null)
                head = node;
            else {
                Node tmp = head;

                int i = 0;
                while (tmp.getNext() != null && i + 1 < index) {
                    tmp = tmp.getNext();
                    i++;
                }
                node.setNext(tmp.getNext());
                tmp.setNext(node);
            }
        }

        public void show() {
            Node tmp = head;
            while (tmp != null) {
                System.out.println(tmp);
                tmp = tmp.getNext();
            }
        }

        public static void put(MyList myList, int[] array) {
            myList.show();
            for (int i = 0; i < array.length; i++) {
                myList.insert(i, array[i]);
            }
            myList.show();
        }
    }

    static class PhoneValidator {

        public static void check() {
            Pattern pattern = Pattern.compile("[0-9\\-+ ]{9,15}");
            try {
                Scanner scanner = new Scanner(new File("1.txt"));
                while (scanner.hasNext()) {
                    Matcher matcher = pattern.matcher(scanner.nextLine());
                    System.out.println(matcher.matches());
                }
            } catch (FileNotFoundException ignored) {
                System.out.println("Nie znaleziono pliku 1.txt");
            }
        }
    }

    static class Binary {

        /*Dany jest plik binarny o jakiejś nazwie, zawierający:
        - 2 bajtów informacji o ilości elementów przechowywanych w pliku (zapisanych w kolejności od najstarszego do najmłodszego bajtu),
        - oraz sekwencję sześciobajtowych wartości, opisujących kolejne elementy.

        Utwórz metodę wczytującą wszystkie dane z pliku i dostarczy jednowymiarową tablicę zawierającą wszystkie dane z pliku.
        Informacja o nazwie pliku zostanie dostarczona jako parametr typu String w nagłówku metody. Zadbaj aby dobrane typy były adekwatne do danych.
         */
        public static String[] loadData(String fileName) {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                ArrayList<String> arrayList = new ArrayList<>();
                int next;
                fileInputStream.skip(2);
                while ((next = fileInputStream.read()) != -1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((char) next);
                    if (stringBuilder.length() == 6) {
                        arrayList.add(stringBuilder.toString());
                    }
                }
                fileInputStream.close();
                return arrayList.toArray(value -> arrayList.toArray(new String[0]));
            } catch (FileNotFoundException ignored) {
                System.out.println("Nie znaleziono pliku " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new String[0];
        }
    }
}
