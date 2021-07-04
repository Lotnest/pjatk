package exercise.ex03.ex03.game;

public enum Play {

    ROCK,
    PAPER,
    SCISSORS;

    public boolean beats(Play play) {
        switch (this) {
            case ROCK:
                switch (play) {
                    case PAPER:
                    case ROCK:
                        return false;
                    case SCISSORS:
                        return true;
                }
                break;
            case PAPER:
                switch (play) {
                    case PAPER:
                    case SCISSORS:
                        return false;
                    case ROCK:
                        return true;
                }
                break;
            case SCISSORS:
                switch (play) {
                    case PAPER:
                        return true;
                    case ROCK:
                    case SCISSORS:
                        return false;
                }
        }
        return false;
    }
}
