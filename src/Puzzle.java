public interface Puzzle extends Cloneable {
    void showPuzzle();
    boolean solve(String answer);
    Puzzle clonePuzzle();
}