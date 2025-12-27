package mastermind.model;

import mastermind.interaction.DraftGuess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Guess {
    private final MainPeg[] pegList;
    private final int numPegs;

    public Guess(int numPegs) {

         this.pegList = new MainPeg[numPegs];
         this.numPegs = numPegs;

        for (int i=0; i<this.numPegs;i++) {
            this.pegList[i] = MainPeg.EMPTY;
        }
    }

    public Guess(DraftGuess draftGuess) {
        List<MainPeg> newPegList = draftGuess.getMainPegList();
        this.pegList = newPegList.toArray(new MainPeg[newPegList.size()]);
        this.numPegs = newPegList.size();
    }

    public boolean isEmpty() {
        for (int i=0; i<this.numPegs;i++) {
            if (this.pegList[i] != MainPeg.EMPTY) {
                return false;
            }
        }
        return true;
    }

    public boolean isFull() {
        boolean full = true;
        for (int i=0; i<this.numPegs;i++) {
            if (this.pegList[i] == MainPeg.EMPTY) {
                full = false;
            }
        }
        return full;
    }

    public List<MainPeg> getMainPegList() {
        return new ArrayList<>(Arrays.asList(pegList));
    }
}
