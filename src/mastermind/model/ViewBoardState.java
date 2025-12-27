package mastermind.model;

import java.util.List;

public final class ViewBoardState {
    private final List<Guess> guesses;

    public ViewBoardState(List<Guess> board) {
        this.guesses = List.copyOf(board);
    }

    public List<Guess> getGuesses() {
        return guesses;
    }
}
