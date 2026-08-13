public class MathPuzzle implements Puzzle {

    private String question;
    private String correctAnswer;

    public MathPuzzle(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public void showPuzzle() {
        System.out.println("\nPuzzle: " + question);
    }

    public boolean solve(String answer) {
        return correctAnswer.equals(answer);
    }

    public Puzzle clonePuzzle() {
        return new MathPuzzle(question, correctAnswer);
    }
}