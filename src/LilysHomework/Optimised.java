package LilysHomework;

import java.util.*;

import static java.util.Collections.swap;

public class Optimised {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Long> a = new ArrayList<>(n);
        ArrayList<Long> copy = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(in.nextLong());
        }
        copy.addAll(a);
        System.out.println(Math.min(getSwaps(a), swapsReversed(copy)));
    }

    private static int swapsReversed(ArrayList<Long> a) {
        Collections.reverse(a);
        return getSwaps(a);
    }

    private static int getSwaps(ArrayList<Long> a) {
        int n = a.size();
        LinkedHashMap<Long, Integer> elemToIndex = new LinkedHashMap<>(n);
        for (int index = 0; index < n; index++) {
            elemToIndex.put(a.get(index), index);
        }
        ArrayList<Long> sortedElems = new ArrayList<>(elemToIndex.keySet());
        Collections.sort(sortedElems);

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            long sortedElem = sortedElems.get(i);
            long elem = a.get(i);
            if (elem != sortedElem) {
                swaps += 1;
                int elemIndex = elemToIndex.get(sortedElem);
                elemToIndex.put(elem, elemIndex);
                swap(a, elemIndex, i);
            }
        }
        return swaps;
    }
}
