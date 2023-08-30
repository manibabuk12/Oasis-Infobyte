import java.util.Scanner;

public class AuthService {
    private static final String CORRECT_USER_ID = "mani123";
    private static final String CORRECT_PIN = "1234";

    public boolean authenticateUser(Scanner scanner) {
        System.out.print("Enter User ID: ");
        String enteredUserId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        if (enteredUserId.equals(CORRECT_USER_ID) && enteredPin.equals(CORRECT_PIN)) {
            System.out.println("Authentication successful.");
            return true;
        } else {
            System.out.println("Authentication failed.");
            return false;
        }
    }
}
