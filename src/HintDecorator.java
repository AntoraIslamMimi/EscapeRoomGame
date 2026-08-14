public class HintDecorator extends PlayerDecorator {

    public HintDecorator(Puzzle puzzle) {
        super(puzzle);
    }

    public void showHint() {
        System.out.println(
                "HINT: Think carefully about the question."
        );
    }

    public void showPuzzle() {
        puzzle.showPuzzle();
        System.out.println("Hint is available.");
    }
}