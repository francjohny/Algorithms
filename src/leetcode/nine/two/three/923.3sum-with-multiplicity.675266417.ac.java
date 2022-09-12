package leetcode.nine.two.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    final long MOD = (long) (1e9 + 7);
    public int threeSumMulti(int[] arr, int target) {
        long count = 0;
        for(int i = 0; i < arr.length; i++) {
            long twoSumCounts = twoSum(arr, target - arr[i], i);
            if(twoSumCounts > 0) {
                count = (count + twoSumCounts) % MOD;
            }
        }
        return (int) count;
    }
    
    private long twoSum(int[] arr, int target, int idx) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        long count = 0;
        for(int i = idx + 1; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                count += (map.get(target - arr[i])).size();
            }
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        return count;
    }
}
