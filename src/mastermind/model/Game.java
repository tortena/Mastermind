package mastermind.model;

import mastermind.interaction.DraftGuess;
import mastermind.interaction.GameConfig;
import mastermind.interaction.ViewBoardState;

public class Game {
    private GameConfig gameConfig;
    private Board board;
    private GameState gameState;

    public Game() {
        this.gameConfig = new GameConfig(4, 12);
        this.initialiseGame();
    }

    public Game(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
        this.initialiseGame();
    }

    private void initialiseGame() {
        this.board = new Board(gameConfig.NUM_PEGS(), gameConfig.NUM_GUESSES());
        this.gameState = GameState.PLACING;
    }

    public void playMove(DraftGuess draftGuess) {
        if (this.gameState == GameState.CORRECT_GUESS
                || this.gameState == GameState.FULL_BOARD
                || this.gameState == GameState.EVALUATING) {
            throw new CannotPlayMoveForGameState();
        }

        this.gameState = GameState.EVALUATING;
        boolean correctGuess = this.board.playMove(draftGuess);

        if (correctGuess) {
            this.gameState = GameState.CORRECT_GUESS;
        } else if (this.board.isFull()) {
            this.gameState = GameState.FULL_BOARD;
        } else {
            this.gameState = GameState.PLACING;
        }
    }

    public ViewBoardState getViewBoardState() {
        return this.board.getViewBoardState();
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public ViewBoardState getViewBoardState(DraftGuess draftGuess) {
        return this.board.getViewBoardState(draftGuess);
    }
}
