public class PuzzleFactory {

    public static Puzzle createPuzzle(int type) {

        if (type == 1) {
            return new MathPuzzle(
                    "What is 10 + 15?",
                    "25"
            );
        }

        if (type == 2) {
            return new WordPuzzle(
                    "What has keys but cannot open locks?",
                    "keyboard"
            );
        }

        if (type == 3) {
            return new MathPuzzle(
                    "What is 8 x 5?",
                    "40"
            );
        }

        return null;
    }
}