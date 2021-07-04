package exercise.ex02.ex01;

public class Cat implements Animal {

    @Override
    public String makeSound() {
        return "meow";
    }

    @Override
    public int getAge() {
        return 10;
    }
}
