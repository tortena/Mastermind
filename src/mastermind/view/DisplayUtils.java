package mastermind.view;

import mastermind.interaction.ViewBoardState;
import mastermind.model.Guess;
import mastermind.model.Hint;
import mastermind.model.HintPeg;
import mastermind.model.MainPeg;

import java.util.List;

public final class DisplayUtils {

    private DisplayUtils() {}

    public static void printWelcome() {
        System.out.println("=================================");
        System.out.println("        MASTERMIND (CLI)          ");
        System.out.println("=================================");
        System.out.println("Enter your guesses using peg names.");
        System.out.println("Example: RED BLUE GREEN YELLOW");
        System.out.println("Colours include: RED BLUE GREEN YELLOW ORANGE WHITE");
        System.out.println();
    }

    public static void printBoard(ViewBoardState boardState) {
        List<Guess> guesses = boardState.getGuesses();
        List<Hint> hints = boardState.getHints();

        System.out.println("Current Board:");
        System.out.println("---------------------------------");

        for (int i = 0; i < guesses.size(); i++) {
            System.out.printf("Guess %2d: %-20s | Hint: %s%n",
                    i + 1,
                    formatGuess(guesses.get(i)),
                    formatHint(hints.get(i)));
        }

        System.out.println("---------------------------------");
    }

    private static String formatGuess(Guess guess) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < guess.getLength(); i++) {
            MainPeg peg = guess.getPegAtIndex(i);
            sb.append(peg.name()).append(" ");
        }

        return sb.toString().trim();
    }

    private static String formatHint(Hint hint) {
        StringBuilder sb = new StringBuilder();

        for (HintPeg peg : hint.getHintList()) {
            sb.append(peg.name()).append(" ");
        }

        return sb.toString().trim();
    }

    public static void printPrompt(int numPegs) {
        System.out.print("Enter " + numPegs + " pegs: ");
    }

    public static void printError(String message) {
        System.out.println("[Error] " + message);
    }

    public static void printWinMessage() {
        System.out.println();
        System.out.println("🎉 Congratulations! You cracked the code!");
    }

    public static void printLoseMessage() {
        System.out.println();
        System.out.println("💀 Game over! The board is full.");
    }
}


