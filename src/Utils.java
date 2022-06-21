
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Utils {

    public static LocalDate getDate(String rawDate){
        return  LocalDate.parse(rawDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

}
