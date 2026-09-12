package mastermind.interaction;

import mastermind.model.MainPeg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DraftGuess {
    private final MainPeg[] pegList;
    private final int numPegs;

    public DraftGuess(int numPegs) {

        this.pegList = new MainPeg[numPegs];
        this.numPegs = numPegs;

        for (int i=0; i<this.numPegs;i++) {
            this.pegList[i] = MainPeg.EMPTY;
        }
    }

    public boolean isFull() {
        for (int i=0; i<this.numPegs;i++) {
            if (this.pegList[i] == MainPeg.EMPTY) {
                return false;
            }
        }
        return true;
    }

    public void setPeg(MainPeg newPeg, int index) throws IndexOutOfBoundsException {
        if (newPeg == MainPeg.EMPTY) {
            throw new InvalidPegChoice();
        }

        for (int i=0; i<this.numPegs;i++) {
            if (i != index && this.pegList[i] == newPeg) {
                throw new InvalidPegChoice();
            }
        }

        this.pegList[index] = newPeg;
    }

    public List<MainPeg> getMainPegList() {
        return new ArrayList<>(Arrays.asList(pegList));
    }
}
