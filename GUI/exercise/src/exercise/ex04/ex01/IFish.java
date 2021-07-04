package exercise.ex04.ex01;

public interface IFish {

    default String swim() {
        return "I can swim";
    }
}
