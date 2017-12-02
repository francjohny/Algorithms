package LilysHomework;

import java.util.*;

/*
 * Whenever George asks Lily to hang out, she's busy doing homework.
 * George wants to help her finish it faster, but he's in over his head!
 * Can you help George understand Lily's homework so she can hang out with him?
 * Consider an array of n distinct integers, A=[a0,a1,...,an-1]. George can swap any two elements of the array any number of times.
 * An array is beautiful if the sum of |ai - ai-1| among all 0 < i < n is minimal possible (after, possibly, performing some swaps).
 *
 * Given the array A, find and print the minimum number of swaps that should be performed in order to make the array beautiful.
 *
 * Input 1:
 * 4
 * 2 5 3 1
 *
 * Output 1:
 * 2
 *
 *
 * Input 2:
 * 8
 * 7 3 0 4 1 6 5 2
 *
 * Output 2:
 * 5
 *
 * Explanation:
 * 7 3 0 4 1 6 5 2 - original array
 * 0 1 2 3 4 5 6 7 - sorted array
 * 0 3 7 4 1 6 5 2 - after first swap
 * 0 1 7 4 3 6 5 2 - after second swap
 * 0 1 2 4 3 6 5 7 - after third swap
 * 0 1 2 3 4 6 5 7 - after fourth swap
 * 0 1 2 3 4 5 6 7 - after fifth swap
 */
public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(in.nextInt());
        }

        System.out.println(Math.min(getSwaps(a), swapsReversed(a)));
    }

    private static int swapsReversed(ArrayList<Integer> a) {
        Collections.reverse(a);
        return getSwaps(a);
    }

    private static int getSwaps(ArrayList<Integer> a) {
        int n = a.size();
        LinkedHashMap<Integer, Integer> elemToIndex = new LinkedHashMap<>(n);
        for (int index = 0; index < n; index++) {
            Integer elem = a.get(index);
            elemToIndex.put(elem, index);
        }
        ArrayList<Integer> sortedElems = new ArrayList<>(elemToIndex.keySet());
        Collections.sort(sortedElems);
        int swaps = 0;
        for (int sortedIndex = 0; sortedIndex < sortedElems.size(); sortedIndex++) {
            Integer sortedElem = sortedElems.get(sortedIndex);
            int elemIndex = elemToIndex.get(sortedElem);
            if (elemIndex != sortedIndex) {
                swaps += 1;
                Integer elem = getKeyFromValue(elemToIndex, sortedIndex); // too slow
                elemToIndex.replace(elem, elemIndex);
                elemToIndex.replace(sortedElem, sortedIndex);
            }
        }
        return swaps;
    }

    private static Integer getKeyFromValue(HashMap<Integer, Integer> map, int value) {
        return map.entrySet().stream().filter(x -> x.getValue() == value).findFirst().get().getKey();
    }

}
