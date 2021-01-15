import java.io.IOException;

public class Main {
    public static void main(final String[] args) {
        
        final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();

        try {
        analyzer.analyze("bt.txt", new BankStatementCSVParser());
        } catch (IOException e){
            System.out.println(e.getStackTrace());
        }
    }
}
