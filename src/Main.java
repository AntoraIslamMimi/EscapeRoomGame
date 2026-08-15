import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        GameManager game = GameManager.getInstance();

        System.out.println("====================================");
        System.out.println("       MYSTERY ESCAPE ROOM");
        System.out.println("====================================");

        System.out.println("\nWelcome to the Escape Room!");
        System.out.println("Your goal is to solve 3 puzzles.");
        System.out.println("You have 3 attempts.");

        System.out.println("\n------------------------------------");
        System.out.println("        SELECT YOUR TOOL");
        System.out.println("------------------------------------");

        System.out.println("1. Normal");
        System.out.println("2. Hint");
        System.out.println("3. Flashlight");

        System.out.print("\nEnter choice: ");
        int toolChoice = input.nextInt();

        Puzzle puzzle1 = PuzzleFactory.createPuzzle(1);

        if (toolChoice == 2) {
            puzzle1 = new HintDecorator(puzzle1);
        }

        if (toolChoice == 3) {
            puzzle1 = new FlashlightDecorator(puzzle1);
        }

        Puzzle clonedPuzzle1 = puzzle1.clonePuzzle();

        System.out.println("\n------------------------------------");
        System.out.println("          PUZZLE 1");
        System.out.println("------------------------------------");

        puzzle1.showPuzzle();

        if (toolChoice == 2) {
            HintDecorator hint =
                    new HintDecorator(puzzle1);

            hint.showHint();
        }

        if (toolChoice == 3) {
            FlashlightDecorator flashlight =
                    new FlashlightDecorator(puzzle1);

            flashlight.useFlashlight();
        }

        input.nextLine();

        System.out.print("\nEnter your answer: ");
        String answer1 = input.nextLine();

        if (puzzle1.solve(answer1)) {

            System.out.println("Correct answer!");
            System.out.println("Puzzle 1 solved.");

            game.increaseScore(20);

        } else {

            System.out.println("Wrong answer!");

            game.decreaseAttempt();

            System.out.println(
                    "Attempts remaining: "
                            + game.getAttempts()
            );
        }

        if (game.hasAttempts()) {

            Puzzle puzzle2 =
                    PuzzleFactory.createPuzzle(2);

            System.out.println("\n------------------------------------");
            System.out.println("          PUZZLE 2");
            System.out.println("------------------------------------");

            puzzle2.showPuzzle();

            System.out.print("\nEnter your answer: ");

            String answer2 = input.nextLine();

            if (puzzle2.solve(answer2)) {

                System.out.println("Correct answer!");
                System.out.println("Puzzle 2 solved.");

                game.increaseScore(30);

            } else {

                System.out.println("Wrong answer!");

                game.decreaseAttempt();

                System.out.println(
                        "Attempts remaining: "
                                + game.getAttempts()
                );
            }
        }

        if (game.hasAttempts()) {

            Puzzle puzzle3 =
                    PuzzleFactory.createPuzzle(3);

            Puzzle clonedPuzzle3 =
                    puzzle3.clonePuzzle();

            System.out.println("\n------------------------------------");
            System.out.println("          PUZZLE 3");
            System.out.println("------------------------------------");

            clonedPuzzle3.showPuzzle();

            System.out.print("\nEnter your answer: ");

            String answer3 = input.nextLine();

            if (clonedPuzzle3.solve(answer3)) {

                System.out.println("Correct answer!");
                System.out.println("Puzzle 3 solved.");

                game.increaseScore(50);

            } else {

                System.out.println("Wrong answer!");

                game.decreaseAttempt();

                System.out.println(
                        "Attempts remaining: "
                                + game.getAttempts()
                );
            }
        }

        System.out.println("\n====================================");
        System.out.println("          GAME RESULT");
        System.out.println("====================================");

        if (game.getScore() == 100) {

            System.out.println("All puzzles solved!");
            System.out.println("You found the exit door!");

            System.out.println("\nUsing Adapter Pattern...");

            LegacyLock oldLock =
                    new LegacyLock();

            Lock lock =
                    new LockAdapter(oldLock);

            lock.unlock();

            System.out.println("\n------------------------------------");
            System.out.println("     CONGRATULATIONS!");
            System.out.println("     YOU ESCAPED THE ROOM!");
            System.out.println("------------------------------------");

        } else {

            System.out.println(
                    "You could not solve all puzzles."
            );

            System.out.println(
                    "The room remains locked."
            );

            System.out.println("\nBetter luck next time!");
        }

        System.out.println(
                "\nFinal Score: "
                        + game.getScore()
        );

        System.out.println(
                "Attempts Remaining: "
                        + game.getAttempts()
        );

        System.out.println("\n====================================");
        System.out.println("             GAME OVER");
        System.out.println("====================================");

        input.close();
    }
}