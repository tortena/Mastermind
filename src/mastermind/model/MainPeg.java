package mastermind.model;

public final class MainPeg {

    private final Colour pegColour;

    public MainPeg(Colour colour) {
        this.pegColour = colour;
    };

    public MainPeg() {
        this.pegColour = Colour.getRandomColour();
    };

    public Colour getColour() {
        return pegColour;
    }

    public boolean sameAs(MainPeg otherPeg) {
        return this.getColour().sameAs(otherPeg.getColour());
    }


}
