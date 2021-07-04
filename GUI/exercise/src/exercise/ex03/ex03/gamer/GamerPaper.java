package exercise.ex03.ex03.gamer;

import exercise.ex03.ex03.game.Play;

public class GamerPaper implements IGamer {

    private final Play play = Play.PAPER;
    private final String name = "Bartek";

    @Override
    public Play play() {
        return play;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "GamerPaper{" +
                "play=" + play +
                ", name='" + name + '\'' +
                '}';
    }
}
