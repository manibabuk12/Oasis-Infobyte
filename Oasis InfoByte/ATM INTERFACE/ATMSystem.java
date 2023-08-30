import java.util.Scanner;

public class ATMSystem {
    private Scanner scanner;
    private AuthService authService;
    private TransactionService transactionService;
    private User currentUser;

    public ATMSystem(Scanner scanner) {
        this.scanner = scanner;
        this.authService = new AuthService();
        this.transactionService = new TransactionService();
    }

    public void run() {
        System.out.println("Welcome to the ATM system!");

        boolean authenticated = authService.authenticateUser(scanner);

        if (authenticated) {
            currentUser = new User("mani123", "1234", 1000.0); 

            boolean quit = false;
            while (!quit) {
                int choice = displayMenuAndTakeInput();
                quit = processMenuChoice(choice);
            }
        } else {
            System.out.println("Authentication failed. Exiting.");
        }
    }

    private int displayMenuAndTakeInput() {
        System.out.println("\nATM Menu:");
        System.out.println("1. View Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private boolean processMenuChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Balance: $" + currentUser.getBalance());
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                currentUser.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                currentUser.withdraw(withdrawAmount);
                break;
            case 4:
                System.out.print("Enter recipient's User ID: ");
                String recipientUserId = scanner.next();
                System.out.print("Enter amount to transfer: ");
                double transferAmount = scanner.nextDouble();
                User recipientUser = new User("recipient123", "", 0.0);
                currentUser.transfer(recipientUser, transferAmount);
                break;
            case 5:
                System.out.println("Exiting ATM. Thank you!");
                return true; 
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        return false; 
    }
}
