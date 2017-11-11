package BigSorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Optimised {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        Arrays.asList(unsorted).sort(new MyComparator());
        for (String anUnsorted : unsorted) {
            System.out.println(anUnsorted);
        }
    }

    static class MyComparator implements Comparator<String> {
        public int compare(String x, String y) {
            if (x.length() == y.length()) {
                return x.compareTo(y);
            }

            return x.length() - y.length();
        }
    }
}
