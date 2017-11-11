package TimeConversion;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InBuilt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time_12hr = in.next();
        String result = LocalTime.parse(time_12hr, DateTimeFormatter.ofPattern("hh:mm:ssa")).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(result);
    }
}
