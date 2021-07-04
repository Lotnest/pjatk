package exercise.ex02.ex01;

public class Cow implements Animal {

    @Override
    public String makeSound() {
        return "moo";
    }

    @Override
    public int getAge() {
        return 10;
    }
}
