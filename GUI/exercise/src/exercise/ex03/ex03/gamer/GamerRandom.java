package exercise.ex03.ex03.gamer;

import exercise.ex03.ex03.game.Play;

import java.security.SecureRandom;

public class GamerRandom implements IGamer {

    private Play play;
    private final String name = "Hades";

    @Override
    public Play play() {
        Play[] zagrania = Play.values();
        return play = zagrania[new SecureRandom().nextInt(zagrania.length)];
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "GamerRandom{" +
                "play=" + play +
                ", name='" + name + '\'' +
                '}';
    }
}
