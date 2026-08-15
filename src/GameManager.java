public class GameManager {

    private static GameManager instance;

    private int score;
    private int attempts;

    private GameManager() {
        score = 0;
        attempts = 3;
    }

    public static GameManager getInstance() {

        if (instance == null) {
            instance = new GameManager();
        }

        return instance;
    }

    public void increaseScore(int points) {
        score = score + points;
    }

    public void decreaseAttempt() {
        attempts--;
    }

    public int getScore() {
        return score;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean hasAttempts() {
        return attempts > 0;
    }
}