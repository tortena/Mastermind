package mastermind.interaction;

import mastermind.model.Guess;
import mastermind.model.Hint;

import java.util.List;

public final class ViewBoardState {
    private final List<Guess> guesses;
    private final List<Hint> hints;

    public ViewBoardState(List<Guess> boardGuesses, List<Hint> boardHints) {
        this.guesses = boardGuesses;
        this.hints = boardHints;
    }

    public List<Guess> getGuesses() {
        return guesses;
    }
    public List<Hint> getHints() {
        return hints;
    }
}
