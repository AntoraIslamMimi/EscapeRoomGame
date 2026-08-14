public class FlashlightDecorator extends PlayerDecorator {

    public FlashlightDecorator(Puzzle puzzle) {
        super(puzzle);
    }

    public void useFlashlight() {
        System.out.println("Flashlight activated.");
        System.out.println("You found a hidden clue!");
    }

    public void showPuzzle() {
        puzzle.showPuzzle();
        System.out.println("Flashlight equipped.");
    }
}