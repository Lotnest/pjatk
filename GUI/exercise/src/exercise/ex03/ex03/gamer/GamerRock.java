package exercise.ex03.ex03.gamer;

import exercise.ex03.ex03.game.Play;

public class GamerRock implements IGamer {

    private final Play play = Play.ROCK;

    @Override
    public Play play() {
        return play;
    }

    @Override
    public String name() {
        return "Michał";
    }
}
