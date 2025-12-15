package mastermind.model;

import com.sun.tools.javac.Main;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MainPegList {
    private List<MainPeg> pegList;
    private int numPegs;

    public MainPegList(int numPegs) {
        //Creates list with n of the same item. new ArrayList<> is needed to convert this from immutable
        // list to a mutable one
         this.pegList = new ArrayList<>(numPegs);
         this.numPegs = numPegs;

        for (int i=0; i<this.numPegs;i++) {
            pegList.add(new MainPeg());
        }
    }

    public boolean isEmpty() {
        boolean empty = false;
        for (int i=0; i<this.numPegs;i++) {
            if (this.pegList.get(i).getColour() != Colour.EMPTY) {
                empty = true;
            }
        }
        return empty;
    }

    public Colour getColourAtIndex(int index) throws IndexOutOfBoundsException {
        return this.pegList.get(index).getColour();
    }

}
