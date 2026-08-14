public abstract class PlayerDecorator implements Puzzle {

    protected Puzzle puzzle;

    public PlayerDecorator(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public void showPuzzle() {
        puzzle.showPuzzle();
    }

    public boolean solve(String answer) {
        return puzzle.solve(answer);
    }

    public Puzzle clonePuzzle() {
        return puzzle.clonePuzzle();
    }
}