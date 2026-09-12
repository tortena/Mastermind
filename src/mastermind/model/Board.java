package mastermind.model;

import mastermind.interaction.DraftGuess;
import mastermind.interaction.ViewBoardState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private Guess[] guesses;
    private Hint[] hints;

    private Guess correctGuess;

    private int maxGuessNum;
    private final int numPegs;
    private int currentGuessNum;

    public Board(int numPegs, int maxGuessNum) {
        this.maxGuessNum=maxGuessNum;
        this.guesses = new Guess[maxGuessNum];
        this.hints = new Hint[maxGuessNum];
        this.numPegs = numPegs;

        for (int i=0; i<this.maxGuessNum;i++) {
            this.guesses[i] = new Guess(numPegs);
            this.hints[i] = Hint.emptyHint(numPegs);
        }

        this.currentGuessNum = 0;

        this.correctGuess = Guess.generateRandomGuess(numPegs);
    }

    public ViewBoardState getViewBoardState(DraftGuess draftGuess) {
        ArrayList<Guess> boardGuesses = new ArrayList<>();
        ArrayList<Hint> boardHints = new ArrayList<>();

        for (int i=0; i < maxGuessNum; i++) {
            if (i== this.currentGuessNum) {
                boardGuesses.add(new Guess(draftGuess));
            } else {
                boardGuesses.add(new Guess(this.guesses[i]));
            }
            boardHints.add(new Hint(this.hints[i]));
        }
        return new ViewBoardState(boardGuesses, boardHints);
    }

    public ViewBoardState getViewBoardState() {
        ArrayList<Guess> boardGuesses = new ArrayList<>();
        ArrayList<Hint> boardHints = new ArrayList<>();

        for (int i=0; i < maxGuessNum; i++) {
            boardGuesses.add(new Guess(this.guesses[i]));
            boardHints.add(new Hint(this.hints[i]));
        }
        return new ViewBoardState(boardGuesses, boardHints);
    }

    public boolean playMove(DraftGuess draftGuess) {
        if (isFull()) throw new FullBoard();
        if (!draftGuess.isFull()) throw new IncompleteGuess();

        Guess newGuess = new Guess(draftGuess);

        Hint hint = generateHintFromGuess(newGuess);

        this.hints[this.currentGuessNum] = hint;
        this.guesses[this.currentGuessNum] = newGuess;

        this.currentGuessNum += 1;

        return this.isCompleteCorrectGuess(newGuess);
    }

    private Hint generateHintFromGuess(Guess guess) {
        List<HintPeg> hintList = new ArrayList<>();

        for (int i=0; i<numPegs; i++) {
            boolean pegAdded = false;
            if (guess.getPegAtIndex(i) == this.correctGuess.getPegAtIndex(i)) {
                hintList.add(HintPeg.CORRECT_POS);
                pegAdded = true;
            } else {
                boolean pegContained = false;
                for (int j=0; j<numPegs; j++) {
                    if (correctGuess.getPegAtIndex(j) == guess.getPegAtIndex(i)) {
                        pegContained = true;
                    }
                }

                if (pegContained) {
                    hintList.add(HintPeg.INCORRECT_POS);
                    pegAdded = true;
                }
            }

            Collections.shuffle(hintList);

            if (!pegAdded) hintList.add(HintPeg.EMPTY);
        }

        return new Hint(hintList);

    }

    private boolean isCompleteCorrectGuess(Guess guess) {
        boolean correct = true;
        for (int i=0; i<numPegs; i++) {
            if (guess.getPegAtIndex(i) != this.correctGuess.getPegAtIndex(i)) {
                correct = false;
            }
        }

        return correct;
    }

    public boolean isFull() {
        return currentGuessNum > maxGuessNum;
    }


}
