package exercise.ex03.ex03;

import exercise.ex03.ex03.game.Play;
import exercise.ex03.ex03.gamer.GamerRandom;
import exercise.ex03.ex04.AdvancedGamerS22373;

public class Main {

    public static void main(String[] args) {
        //Arena arena = new Arena(new GamerScissors(), new GamerRandom());
        //arena.fight(5);

        AdvancedGamerS22373 advancedGamerS22373 = new AdvancedGamerS22373();
        int advancedGamerS22373Score = 0;
        for (int i = 0; i < 1000; i++) {
            Play gamerRandomPlay = new GamerRandom().play();
            Play advancedGamerS22373Play = advancedGamerS22373.play(gamerRandomPlay);
            System.out.println(gamerRandomPlay + " VS " + advancedGamerS22373Play);
            System.out.println(gamerRandomPlay.beats(advancedGamerS22373Play) ? false : ++advancedGamerS22373Score);
        }
    }
}
