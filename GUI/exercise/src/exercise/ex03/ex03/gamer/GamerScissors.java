package exercise.ex03.ex03.gamer;

import exercise.ex03.ex03.game.Play;

public class GamerScissors implements IGamer {

    private final Play play = Play.SCISSORS;

    @Override
    public Play play() {
        return play;
    }

    @Override
    public String name() {
        return "Adrian";
    }
}
