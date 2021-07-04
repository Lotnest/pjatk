package exercise.ex02.ex01;

public class Main {

    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = new Cow();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            System.out.println(animal.getAge());
            System.out.println();
        }
    }
}
