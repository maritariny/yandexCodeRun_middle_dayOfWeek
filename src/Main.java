import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        String[] weekdays = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        Map<String, Integer> months = new HashMap<>();
        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 10);
        months.put("November", 11);
        months.put("December", 12);

        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int d = Integer.parseInt(parts[0]);
            String m = parts[1];
            int y = Integer.parseInt(parts[2]);
            LocalDate localDate = LocalDate.of(y, months.get(m), d);
            String result = weekdays[localDate.getDayOfWeek().getValue() - 1];
            System.out.println(result);
        }
        sc.close();
    }

    public static String getDayOfWeekSimpleDateFormat(String s) throws ParseException  {
        Date date = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH).parse(s);
        SimpleDateFormat dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        return dayOfWeek.format(date);
    }

    public static String getDayOfWeekLocalDate(String s, String[] weekdays) throws ParseException  {
        Date date = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH).parse(s);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String result = weekdays[localDate.getDayOfWeek().getValue() - 1];
        return result;
    }
}