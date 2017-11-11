package BigSorting;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Naive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        Arrays.stream(unsorted).map(BigInteger::new).sorted().forEach(System.out::println); // pretty slow
    }
}
