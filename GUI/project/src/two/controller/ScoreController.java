package two.controller;

import two.model.Score;

public class ScoreController {

    private final Score score;

    public ScoreController(final Score score) {
        this.score = score;
    }

    public Score getScore() {
        return score;
    }

    public void updateCardsMatched() {
        score.setCardsMatched(score.getCardsMatched() + 1);
    }
}
