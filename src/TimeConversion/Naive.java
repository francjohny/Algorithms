package TimeConversion;

import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time_12hr = in.next();
        int n = time_12hr.length();
        String period = time_12hr.substring(n - 2);
        String time_24hr = convertTo24hrs(time_12hr, period);
        System.out.println(time_24hr);
    }

    private static String convertTo24hrs(String time_12hr, String period) {
        String[] time_parts = time_12hr.split(":");
        int hrs = Integer.parseInt(time_parts[0]) % 12;
        String time_24hr = null;
        switch (period) {
            case "AM":
                time_24hr =  String.format("%02d", hrs) + time_12hr.substring(2, time_12hr.length() - 2);
                break;
            case "PM":
                time_24hr =  String.format("%02d", hrs + 12) + time_12hr.substring(2, time_12hr.length() - 2);
                break;
        }
        return time_24hr;
    }
}
