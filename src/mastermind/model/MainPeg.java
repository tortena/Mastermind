package mastermind.model;

public enum MainPeg { // Good for constants, have type checking (e.g. RED)
    EMPTY(),
    RED(),
    GREEN(),
    BLUE(),
    YELLOW(),
    ORANGE(),
    WHITE();


    public static MainPeg getRandomColour() {
        MainPeg[] allMainPegs = MainPeg.values();

        return allMainPegs[(int)(Math.random()*(allMainPegs.length))];
    }

}
