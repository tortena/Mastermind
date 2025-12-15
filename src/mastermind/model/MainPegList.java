package mastermind.model;

import java.util.List;
import java.util.ArrayList;

public class MainPegList {
    private List<MainPeg> pegList;

    public MainPegList(int numPegs) {
         this.pegList = new ArrayList<>(numPegs);
         for (int i=0; i<numPegs;i++) {
             this.pegList.add(null);
         }
    }



}
