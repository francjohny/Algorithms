package RunningMedian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InBuilt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> integers = new ArrayList<>(n);
        while (n-- > 0) {
            Integer elem = in.nextInt();
            int pos = Collections.binarySearch(integers, elem);
            if (pos < 0) pos = Math.abs(pos) - 1;
            integers.add(pos, elem);
            Double median = median(integers);
            System.out.printf("%.1f\n", median);
        }
    }

    private static double median(List<Integer> data) {
        if ((data.size() & 1) == 1) { // check if odd number
            return data.get(data.size() / 2);
        } else {
            int midSize = data.size() / 2;
            return (data.get(midSize - 1) + data.get(midSize)) / 2.0;
        }
    }
}
