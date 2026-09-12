package mastermind.model;

import mastermind.interaction.DraftGuess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    public Guess(Guess guess) {
        this.pegList = new MainPeg[guess.getLength()];
        this.numPegs = guess.getLength();

        for (int i=0; i<this.numPegs;i++) {
            this.pegList[i] = guess.pegList[i];
        }
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

    public MainPeg getPegAtIndex(int i) {
        return this.pegList[i];
    }

    public List<MainPeg> getMainPegList() {
        return new ArrayList<>(Arrays.asList(pegList.clone()));
    }

    public static Guess generateRandomGuess(int numPegs) {
        Guess randomGuess = new Guess(numPegs);
        Random RANDOM = new Random();

        MainPeg[] values = MainPeg.values();

        for (int i=0; i<numPegs;i++) {
            boolean newPegIsUnique = false;
            MainPeg newPeg = MainPeg.EMPTY;
            while (!newPegIsUnique) {
                newPeg = values[RANDOM.nextInt(values.length)];

                newPegIsUnique = true;
                for (int j=0; j<i;j++) {
                    if (newPeg == randomGuess.getPegAtIndex(i)) newPegIsUnique = false;
                }
                if (newPeg==MainPeg.EMPTY) newPegIsUnique = false;
            }

            randomGuess.pegList[i] = newPeg;
        }

        return randomGuess;
    }

    public int getLength() {
        return this.numPegs;
    }
}