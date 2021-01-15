import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;


public class BankTransactionAnalyzerSimple {

    private static final String RESOURSES = "java.real.life\\src\\bT.txt";

    public static void main (final String... args) throws IOException{

        final Path path = Paths.get(RESOURSES);
        double total = 0d;
        double total2 = 0d;

        Stream<String> lines = Files.readAllLines(path).stream();
        total = lines.map(line -> Double.parseDouble(line.split(",")[1])).reduce(0.0, Double::sum);

        lines.forEach(line -> System.out.println(line.split(",")[2]));

        List<String> lines2 = Files.readAllLines(path);

        for(final String line: lines2){
            final String[] amount = line.split(",");
            total2 += Double.parseDouble(amount[1]);

        }

        System.out.println("The total for all the transactions is: " + total);
        System.out.println("The total for all the transactions from second method is: " + total2);

        lines.close();
    }
    
}
