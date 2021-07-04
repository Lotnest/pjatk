package exercise.ex03.ex03.game;

import exercise.ex03.ex03.gamer.IGamer;

public class Arena {

    private IGamer iGamer1;
    private IGamer iGamer2;
    private int iGamer1Score;
    private int iGamer2Score;

    public Arena(IGamer iGamer1, IGamer iGamer2) {
        this.iGamer1 = iGamer1;
        this.iGamer2 = iGamer2;
        iGamer1Score = 0;
        iGamer2Score = 0;
    }

    public IGamer getIGamer1() {
        return iGamer1;
    }

    public IGamer getIGamer2() {
        return iGamer2;
    }

    public void setIGamer1(IGamer iGamer1) {
        this.iGamer1 = iGamer1;
    }

    public void setIGamer2(IGamer iGamer2) {
        this.iGamer2 = iGamer2;
    }

    public int getIGamer1Score() {
        return iGamer1Score;
    }

    public void setIGamer1Score(int iGamer1Score) {
        this.iGamer1Score = iGamer1Score;
    }

    public int getIGamer2Score() {
        return iGamer2Score;
    }

    public void setIGamer2Score(Integer iGamer2Score) {
        this.iGamer2Score = iGamer2Score;
    }

    public void winLogic() {
        final Play iGamer1Play = iGamer1.play();
        final Play iGamer2Play = iGamer2.play();
        final String iGamer1Name = iGamer1.name();
        final String iGamer2Name = iGamer2.name();

        System.out.println(iGamer1Name + " chose " + iGamer1Play + ".");
        System.out.println(iGamer2Name + " chose " + iGamer2Play + ".");
        System.out.println();
        if (iGamer1Play.equals(iGamer2Play)) {
            System.out.println("Draw! Each player scores one point (" + ++iGamer1Score + ":" + ++iGamer2Score + ").");
        } else {
            try {
                Thread.sleep(250);
                if (iGamer1Play.beats(iGamer2Play)) {
                    System.out.println(iGamer1Name + " wygrywa tę rundę i zdobywa jeden punkt (" + ++iGamer1Score + ":" + iGamer2Score + ").");
                } else {
                    System.out.println(iGamer2Name + " wygrywa tę rundę i zdobywa jeden punkt (" + iGamer1Score + ":" + ++iGamer2Score + ").");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void fight(int rounds) {
        final String iGamer1Name = iGamer1.name();
        final String iGamer2Name = iGamer2.name();
        System.out.println(iGamer1Name + " VS " + iGamer2Name);
        for (int i = 0; i < rounds; i++) {
            System.out.println();
            System.out.println("Round " + (i + 1));
            System.out.println();
            for (int j = 3; j > 0; j--) {
                System.out.println(j);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            winLogic();
        }
        if (iGamer1Score != iGamer2Score) {
            System.out.println("\n=====================================================");
            System.out.println("Game has ended! " + (iGamer1Score > iGamer2Score ? iGamer1Name + " (" + iGamer1Score + " > " + iGamer2Score + ")" : iGamer2Name + " (" + iGamer2Score + " > " + iGamer1Score + ")") + " wins.");
            System.out.println("=====================================================");
        } else {
            System.out.println("\n=====================================================");
            System.out.println("Game has ended! Both players have the same number of points, no winner. (" + iGamer1Score + " = " + iGamer2Score + ")");
            System.out.println("=====================================================");
        }
    }
}
