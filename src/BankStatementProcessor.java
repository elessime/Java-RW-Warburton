import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions){
        this.bankTransactions = bankTransactions;
    }
    
    public double calculateTotalAmount(){
        Stream<BankTransaction> bankTransactionsStream = this.bankTransactions.stream();
        double total = bankTransactionsStream.map(transaction -> transaction.getAmount()).reduce(0.0, Double::sum);
        bankTransactionsStream.close();
        return total;
    }

    public double calculateTotalInMonth(final Month month){

        double total = 0.0d;
        Stream<BankTransaction> bankTransactionsStream = this.bankTransactions.stream();
        final List<BankTransaction> bankTransactionsInMonth = bankTransactionsStream.filter
        (x -> x.getDate().getMonth().equals(month)).collect(Collectors.toList());
        bankTransactionsStream.close();
        for(BankTransaction transaction: bankTransactionsInMonth){
            total += transaction.getAmount();
        }
        return total;
    }

    public Double calculateTotalForCategory(final String category) {
        double total = 0.0d;
        for (BankTransaction transaction: this.bankTransactions){
            if (transaction.getDescription().equals(category)){
                total += transaction.getAmount();
            }
        }

        return  total;

    }
}
