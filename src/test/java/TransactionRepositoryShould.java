import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

/**
 * Created by Marcel on 1/4/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {

    private static final String TODAY = "12/05/2015";
    private TransactionRepository transactionRepository;
    @Mock Clock clock;

    @Before
    public void setUp() throws Exception {
        transactionRepository = new TransactionRepository(clock);
        given(clock.todayAsString()).willReturn(TODAY);
    }

    @Test
    public void create_and_store_a_deposit_transaction() throws Exception{

        transactionRepository.addDeposit(100);

        List<Transaction> transactions = transactionRepository.allTransactions();

        assertThat(transactions.size(),is(1));
        assertThat(transactions.get(0),is(transaction(TODAY,100)));
    }

    @Test
    public void create_and_store_a_withdrawal_transaction() throws Exception{

        transactionRepository.addWithdrawal(100);

        List<Transaction> transactions = transactionRepository.allTransactions();

        assertThat(transactions.size(),is(1));
        assertThat(transactions.get(0),is(transaction(TODAY,-100)));
    }
    private Transaction transaction(String date, int amount) {

        return new Transaction(date, amount);
    }
}