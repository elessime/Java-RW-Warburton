import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SumOfMonthlyPayments {
    
    private static final String RESOURSES = "src\\bT.txt";

    public static void main (final String... args) throws IOException{

        final Path path = Paths.get(RESOURSES);
        double total = 0d;

        List<String> lines = Files.readAllLines(path);

        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyy");

        for(final String line: lines){
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);

            if(date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }

        }



        System.out.println("The total for all transactions in January is: " + total);

    }
}
