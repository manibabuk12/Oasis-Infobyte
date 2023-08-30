public class User {
    private String userId;
    private String pin;
    private double balance;

    public User(String userId, String pin, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Invalid amount for withdrawal or insufficient balance.");
        }
    }

    public void transfer(User recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            System.out.println("Transferred: $" + amount + " to user " + recipient.getUserId());
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Invalid amount for transfer or insufficient balance.");
        }
    }
}
