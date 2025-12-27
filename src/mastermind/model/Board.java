package mastermind.model;

import mastermind.interaction.DraftGuess;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private Guess[] guesses;
    private int maxGuessNum;
    private final int numPegs;
    private int currentGuessNum;

    public Board(int maxGuessNum, int numPegs) {
        this.maxGuessNum=maxGuessNum;
        this.guesses = new Guess[maxGuessNum];
        this.numPegs = numPegs;

        for (int i=0; i<this.maxGuessNum;i++) {
            guesses[i] = new Guess(numPegs);
        }

        this.currentGuessNum = 0;
    }

    public ViewBoardState getViewBoardState(DraftGuess draftGuess) {
        this.guesses[this.currentGuessNum] = new Guess(draftGuess);
        ViewBoardState viewBoardState = new ViewBoardState(new ArrayList<>(Arrays.asList(this.guesses)));
        this.guesses[this.currentGuessNum] = new Guess(this.numPegs);
        return viewBoardState;
    }

    public ViewBoardState getViewBoardState() {
        return new ViewBoardState(new ArrayList<>(Arrays.asList(this.guesses)));
    }

    public void setNextMove(DraftGuess draftGuess) {
        this.guesses[this.currentGuessNum] = new Guess(draftGuess);
        this.currentGuessNum += 1;
    }


}
