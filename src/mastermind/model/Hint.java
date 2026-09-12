package mastermind.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hint {
    private final HintPeg[] pegList;
    private final int numPegs;

    public static Hint emptyHint(int numPegs) {
        List<HintPeg> hintList = new ArrayList<>();

        for (int i=0; i<numPegs;i++) {
            hintList.add(HintPeg.EMPTY);
        }

        return new Hint(hintList);
    }


    public Hint(List<HintPeg> newPegList) {
        this.pegList = newPegList.toArray(new HintPeg[newPegList.size()]);
        this.numPegs = newPegList.size();
    }

    public Hint(Hint hint) {
        this.pegList = new HintPeg[hint.getLength()];
        this.numPegs = hint.getLength();

        for (int i=0; i<this.numPegs;i++) {
            this.pegList[i] = hint.pegList[i];
        }
    }

    public List<HintPeg> getHintList() {
        return Arrays.asList(this.pegList);
    }

    public int getLength() {
        return this.numPegs;
    }
}
