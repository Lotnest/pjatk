package exercise.ex03.ex03.gamer;

import exercise.ex03.ex03.game.Play;

public abstract class AdvancedGamer {

    public abstract String name();

    public abstract Play fake();

    public abstract Play play(Play fake);

    public abstract void result(boolean score, Play enemyMove);
}
