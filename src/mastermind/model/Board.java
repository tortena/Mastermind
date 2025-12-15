package mastermind.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Board {
    private List<MainPegList> guesses;
    private int guessNum;

    public Board(int guessNum, int numPegs) {
        this.guessNum=guessNum;
        this.guesses = new ArrayList<>(guessNum);

        for (int i=0; i<this.guessNum;i++) {
            guesses.add(new MainPegList(numPegs));
        }
    }
}
