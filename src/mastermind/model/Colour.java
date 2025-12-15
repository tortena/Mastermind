package mastermind.model;

public enum Colour { // Good for constants, have type checking (e.g. RED)
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF"),
    YELLOW("#FFFF00"),
    ORANGE("#FFA500"),
    WHITE("FFFFFF");

    private final String hex;

    Colour(String hex) {
        this.hex = hex; // cannot make public apparently
    }

    public String getHex() {
        return this.hex;
    }

    public boolean sameAs(Colour otherColour) {
        return this == otherColour;
        //Enums CAN be compared like this as they are singletons
        //i.e., each enum constant is guaranteed to exist ONLY once!
        //Therefore, comparing references is exactly what we want
    }

    public static Colour getRandomColour() {
        Colour[] allColours = Colour.values();

        return allColours[(int)(Math.random()*(allColours.length))];
    }

}
