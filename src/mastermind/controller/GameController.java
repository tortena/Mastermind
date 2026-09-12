package mastermind.controller;

import mastermind.interaction.InvalidPegChoice;
import mastermind.model.Game;
import mastermind.model.GameState;
import mastermind.interaction.DraftGuess;
import mastermind.view.DisplayUtils;
import mastermind.model.MainPeg;

import java.util.Scanner;

public class GameController {

    private final Game game;
    private final Scanner scanner;
    private final int numPegs;

    public GameController(Game game, int numPegs) {
        this.game = game;
        this.numPegs = numPegs;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        DisplayUtils.printWelcome();

        while (true) {
            DisplayUtils.printBoard(game.getViewBoardState());

            if (game.getGameState() == GameState.CORRECT_GUESS) {
                DisplayUtils.printWinMessage();
                break;
            }

            if (game.getGameState() == GameState.FULL_BOARD) {
                DisplayUtils.printLoseMessage();
                break;
            }

            DraftGuess draftGuess = readGuess();
            game.playMove(draftGuess);
        }

        scanner.close();
    }

    private DraftGuess readGuess() {
        DraftGuess draftGuess = new DraftGuess(numPegs);

        while (true) {
            DisplayUtils.printPrompt(numPegs);
            String line = scanner.nextLine().trim();

            String[] tokens = line.split("\\s+");
            if (tokens.length != numPegs) {
                DisplayUtils.printError("You must enter exactly " + numPegs + " pegs.");
                continue;
            }

            try {
                for (int i = 0; i < numPegs; i++) {
                    MainPeg peg = MainPeg.valueOf(tokens[i].toUpperCase());
                    draftGuess.setPeg(peg, i);
                }
                return draftGuess;

            } catch (IllegalArgumentException | InvalidPegChoice e) {
                DisplayUtils.printError("Invalid peg name. Use valid MainPeg values.");
            }
        }
    }

    public static void main(String[] args) {
        GameController controller = new GameController(new Game(), 4);

        controller.run();
    }
}