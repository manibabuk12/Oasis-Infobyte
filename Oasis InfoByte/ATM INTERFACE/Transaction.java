import java.time.LocalDateTime;

public class Transaction {
    private TransactionType type;
    private double amount;
    private LocalDateTime timestamp;
    private User user;

    public Transaction(TransactionType type, double amount, User user) {
        this.type = type;
        this.amount = amount;
        this.user = user;
        this.timestamp = LocalDateTime.now();
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}
