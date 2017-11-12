package BigSorting;

import java.util.Arrays;
import java.util.Scanner;

/*
 * A more optimised solution would be to sort the string array based on length and lexicographically for same-length numbers
 */
public class Optimised {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
            unsorted[unsorted_i] = in.next();
        }

        Arrays.sort(unsorted, (x, y) -> {
            if (x.length() == y.length()) {
                return x.compareTo(y);
            }
            return x.length() - y.length();
        });

        for (String number : unsorted) {
            System.out.println(number);
        }
    }
}
