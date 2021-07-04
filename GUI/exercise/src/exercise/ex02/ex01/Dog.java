package exercise.ex02.ex01;

public class Dog implements Animal {

    @Override
    public String makeSound() {
        return "woof";
    }

    @Override
    public int getAge() {
        return 10;
    }
}
