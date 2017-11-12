package RunningMedian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * The median of a dataset of integers is the midpoint value of the dataset for which an equal number of integers are less than and greater than the value.
 * To find the median, you must first sort your dataset of integers in non-decreasing order, then:
 * If your dataset contains an odd number of elements, the median is the middle element of the sorted sample.
 * If your dataset contains an even number of elements, the median is the average of the two middle elements of the sorted sample.
 *
 * Input:
 * 6
 * 12
 * 4
 * 5
 * 3
 * 8
 * 7
 *
 * Output:
 * 6
 * 12
 * 4
 * 5
 * 3
 * 8
 * 7
 */
public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> integers = new ArrayList<>(n);
        while (n-- > 0) {
            Integer elem = in.nextInt();
//            insertElem(integers, elem);
            int pos = indexedBinarySearch(integers, elem);
            if (pos < 0)
                pos = Math.abs(pos) - 1;
            integers.add(pos, elem);
            Double median = computeMedian(integers);
            System.out.printf("%.1f\n", median);
        }
    }

    private static Double computeMedian(List<Integer> integers) {
        int n = integers.size();
        int mid = n / 2;
        if (n % 2 == 0) {
            return (integers.get(mid - 1) + integers.get(mid)) / 2.0;
        } else
            return integers.get(mid).doubleValue();
    }

    private static void insertElem(List<Integer> list, Integer elem) {
        int n = list.size();
        if (list.isEmpty()) {
            list.add(elem);
        } else if (n == 1) {
            if (elem < list.get(0))
                list.add(0, elem);
            else
                list.add(elem);
        } else {
            int low = 0, high = n - 1;
            while (low <= high) {
                int median = (low + high) >>> 1;
                Integer midValue = list.get(median);
                int cmp = midValue.compareTo(elem);
                if (cmp < 0)
                    low = median + 1;
                else if (cmp > 0)
                    high = median - 1;
            }
            list.add(low, elem);
        }
    }

    private static int indexedBinarySearch(List<Integer> list, Integer key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Integer midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }
}
