import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int score = 0;

        Random random = new Random();
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number Game!");

        for (int attempts = 1; attempts <= maxAttempts; attempts++) {
            String guessStr = JOptionPane.showInputDialog("Attempt " + attempts + "/" + maxAttempts +
                    "\nEnter your guess between " + lowerBound + " and " + upperBound + ":");
            int userGuess = Integer.parseInt(guessStr);

            if (userGuess == randomNumber) {
                score += (maxAttempts - attempts + 1);
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number " +
                        randomNumber + " in " + attempts + " attempts.\nYour current score: " + score);
                break;
            } else if (userGuess < randomNumber) {
                JOptionPane.showMessageDialog(null, "Try again! Your guess is too low.");
            } else {
                JOptionPane.showMessageDialog(null, "Try again! Your guess is too high.");
            }

            if (attempts == maxAttempts) {
                JOptionPane.showMessageDialog(null, "Sorry, you've reached the maximum number of attempts. The number was: " + randomNumber);
            }
        }
    }
}
