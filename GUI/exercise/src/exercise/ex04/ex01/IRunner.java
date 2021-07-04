package exercise.ex04.ex01;

public interface IRunner {

    default String run() {
        return "I can run";
    }
}
