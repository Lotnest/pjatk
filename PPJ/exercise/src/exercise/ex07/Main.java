package exercise.ex07;

public class Main {

    public static void main(String[] args) {
        int i = 4;
        float f = 3.5f;
        char c = 'c';
        byte b = 2;

        MethodCurrier methodCurrier = new MethodCurrier();
        methodCurrier.setValue(i);
        methodCurrier.setValue(f);
        methodCurrier.setValue(c);
        methodCurrier.setValue(b);

        Number number = new Number();
        number.showValue();
        methodCurrier.setValue(number);
        number.showValue();

        System.out.println();
        Person person = new Person();
        person.name = "Adam";
        person.lastName = "Kowalski";
        person.birthYear = 1980;

        Person person1 = new Person("Bartek", "Bartkowski", 1995);
        person1.show();

        System.out.println();
        Cplx cplx = new Cplx(4, 5);
    }
}

class MethodCurrier {

    void setValue(int i) {
        System.out.println("int: " + i);
        i += 1;
        System.out.println("int: " + i);
    }

    void setValue(float f) {
        System.out.println("float: " + f);
        f += 5;
        System.out.println("float: " + f);
    }

    void setValue(Number number) {
        number.showValue();
        number.setValue(10);
        number.showValue();
    }
}

class Number {

    int value;

    void setValue(int value) {
        this.value = value;
    }

    void showValue() {
        System.out.println(value);
    }
}

class Person {

    public String name;
    public String lastName;
    public int birthYear;

    public Person() {
    }

    public Person(String name, String lastName, int birthYear) {
        this.name = name;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public void show() {
        System.out.println("Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rokUrodzenia=" + birthYear +
                '}');
    }
}

class Cplx {

    private double real;
    private double imaginary;

    public Cplx(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void add(Cplx cplx) {
        real += cplx.real;
        imaginary += cplx.imaginary;
    }

    public void sub(Cplx cplx) {
        real -= cplx.real;
        imaginary -= cplx.imaginary;
    }

    public void mul(Cplx cplx) {

    }

    public void inc() {
        real += 1;
    }

    public void show() {
        System.out.println(real + " + " + imaginary + "i");
    }
}
