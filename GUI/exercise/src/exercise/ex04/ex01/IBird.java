package exercise.ex04.ex01;

public interface IBird {

    default String fly() {
        return "I can fly";
    }
}
