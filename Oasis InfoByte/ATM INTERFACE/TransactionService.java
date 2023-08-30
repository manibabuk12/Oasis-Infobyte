import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    private List<Transaction> transactionHistory;

    public TransactionService() {
        transactionHistory = new ArrayList<>();
    }

    public void recordTransaction(Transaction type, double amount, User user) {
        Transaction transaction = new Transaction(type, amount, user);
        transactionHistory.add(transaction);
    }

    public List<Transaction> getTransactionHistory(User user) {
        List<Transaction> userTransactions = new ArrayList<>();
        for (Transaction transaction : transactionHistory) {
            if (transaction.getUser() == user) {
                userTransactions.add(transaction);
            }
        }
        return userTransactions;
    }
}
