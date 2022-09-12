package leetcode.three.four.seven;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        List<Integer>[] freq = new List[Math.max(nums.length, max) + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (freq[entry.getValue()] == null)
                freq[entry.getValue()] = new ArrayList<>();
            freq[entry.getValue()].add(entry.getKey());
            
        }
        int[] result = new int[k];
        int j = 0;
        for(int i = freq.length - 1; i >= 0 && j < k; i--) {
            if (freq[i] != null)
                for(Integer elem: freq[i])
                    result[j++] = elem;
        }
        return result;
    }
}
