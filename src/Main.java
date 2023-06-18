import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            System.out.println("Game: Rock, Paper, Scissors!");

            String playerAMove = getPlayerMove(scanner, "A");
            String playerBMove = getPlayerMove(scanner, "B");

            String result = getResult(playerAMove, playerBMove);

            System.out.println(result);
            System.out.println("Do you want to play again? [Y/N]");
            playAgain = scanner.nextLine();

        } while (playAgain.equalsIgnoreCase("Y"));

        scanner.close();
        System.out.println("Thanks for playing!");
    }

    private static String getPlayerMove(Scanner scanner, String player) {
        String move;
        do {
            System.out.println("Player " + player + ", Choose your move: [R, P, S]");
            move = scanner.nextLine().toUpperCase();
        } while (!move.equals("R") && !move.equals("P") && !move.equals("S"));

        return move;
    }

    private static String getResult(String playerAMove, String playerBMove) {
        if (playerAMove.equals(playerBMove)) {
            return "Rock vs Rock it’s a Tie!";
        } else if ((playerAMove.equals("R") && playerBMove.equals("S"))
                || (playerAMove.equals("P") && playerBMove.equals("R"))
                || (playerAMove.equals("S") && playerBMove.equals("P"))) {
            return "Player A wins: " + getWinningPhrase(playerAMove, playerBMove);
        } else {
            return "Player B wins: " + getWinningPhrase(playerBMove, playerAMove);
        }
    }

    private static String getWinningPhrase(String winningMove, String losingMove) {
        switch (winningMove) {
            case "R":
                return "Rock breaks Scissors";
            case "P":
                return "Paper covers Rock";
            case "S":
                return "Scissors cuts Paper";
            default:
                return "";
        }
    }
}
