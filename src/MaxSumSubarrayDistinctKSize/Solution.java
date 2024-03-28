package MaxSumSubarrayDistinctKSize;

import java.util.*;

class Solution {
    public static long maximumSubarraySum(int[] nums, int k) {
        int low = 0, high = 0, n = nums.length;
        long max = 0, sum = 0;
        Set<Integer> set = Collections.newSetFromMap(new LinkedHashMap<>() {
            protected boolean removeEldestEntry(Map.Entry<Integer, Boolean> eldest) {
                return size() > k;
            }
        });
        Map<Integer, Integer> lastPos = new HashMap<>();
        while (high < n) {
            if (!set.add(nums[high])) {
                int nextLow = lastPos.get(nums[high]) + 1;
                while (low < nextLow) {
                    sum -= nums[low++];
                }
            }
            sum += nums[high];
            lastPos.put(nums[high], high);

            if ((high - low + 1) >= k) {
                if ((high - low + 1) > k) {
                    sum -= nums[low++];
//                    Iterator<Integer> iterator = set.iterator();
//                    iterator.next();
//                    iterator.remove();
//                    set.remove(set.iterator().next());
                    System.out.println(set);
                }
                max = Math.max(max, sum);
            }
            high++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
    }
}