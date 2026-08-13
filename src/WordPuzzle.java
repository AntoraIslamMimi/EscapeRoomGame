public class WordPuzzle implements Puzzle {

    private String question;
    private String correctAnswer;

    public WordPuzzle(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public void showPuzzle() {
        System.out.println("\nPuzzle: " + question);
    }

    public boolean solve(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }

    public Puzzle clonePuzzle() {
        return new WordPuzzle(question, correctAnswer);
    }
}