import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Marcel on 1/4/2017.
 */
public class TransactionRepository {
    private Clock clock;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public TransactionRepository(Clock clock) {

        this.clock = clock;
    }

    public void addDeposit(int amount) {
        Transaction deposit = new Transaction(clock.todayAsString(),amount);
        transactions.add(deposit);
    }

    public void addWithdrawal(int amount) {
        Transaction withdrawTransaction = new Transaction(clock.todayAsString(),-amount);
        transactions.add(withdrawTransaction);
    }

    public List<Transaction> allTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
