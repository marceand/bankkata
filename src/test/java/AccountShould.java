import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by Marcel on 1/4/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

    @Mock TransactionRepository transactionRepository;
    @Mock StatementPrinter statementPrinter;
    private Account account;


    @Before
    public void setUp() throws Exception {
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void store_a_deposit_transaction() throws Exception{
        account.deposit(100);
        verify(transactionRepository).addDeposit(100);
    }

    @Test
    public void store_a_withdrawal_transaction() throws Exception{
        account.withdraw(100);
        verify(transactionRepository).addWithdrawal(100);
    }

    @Test
    public void print_a_statement() throws Exception{

        List<Transaction> transactions = asList(new Transaction("12/05/2015",100));

        given(transactionRepository.allTransactions()).willReturn(transactions);

        account.printStatement();

        verify(statementPrinter).print(transactions);
    }

}