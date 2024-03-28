package TopKFrequentElements;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 */
public class Program {
    public static void main(String[] args) {
        int[] ans = topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
        for (int item :
                ans) {
            System.out.print(item + " ");
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> queue = new PriorityQueue<>(map.size(), (t1, t2) -> map.get(t2).compareTo(map.get(t1)));
        queue.addAll(map.keySet());
        List<Integer> topKElems = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topKElems.add(queue.poll());
        }
        return topKElems.stream().mapToInt(x -> x).toArray();
    }
}
