package exercise.ex03.ex04;

import exercise.ex03.ex03.game.Play;
import exercise.ex03.ex03.gamer.AdvancedGamer;

import java.util.LinkedList;

public class AdvancedGamerS22373 extends AdvancedGamer {

    private static final LinkedList<Play> enemyMoves = new LinkedList<>();

    @Override
    public String name() {
        return "S22373";
    }

    @Override
    public Play fake() {
        int paperCount = 0;
        int rockCount = 0;
        int scissorsCount = 0;
        for (Play enemyMove : enemyMoves) {
            switch (enemyMove) {
                case PAPER:
                    paperCount++;
                    break;
                case ROCK:
                    rockCount++;
                    break;
                case SCISSORS:
                    scissorsCount++;
                    break;
            }
        }
        int max = Math.max(paperCount, Math.max(rockCount, scissorsCount));
        Play mostPlayed = max == paperCount ? (max == rockCount ? (max == scissorsCount ? Play.SCISSORS : Play.ROCK) : Play.PAPER) : Play.SCISSORS;
        switch (mostPlayed) {
            case PAPER:
                return Play.SCISSORS;
            case ROCK:
                return Play.PAPER;
            case SCISSORS:
                return Play.ROCK;
        }
        throw new IllegalStateException("Could not predict the next play");
    }

    @Override
    public Play play(Play fake) {
        enemyMoves.add(fake);
        return this.fake();
    }

    @Override
    public void result(boolean score, Play enemyMove) {
        if (!score) {
            enemyMoves.remove(enemyMoves.size() - 1);
        }
    }

    public LinkedList<Play> getEnemyMoves() {
        return enemyMoves;
    }
}
