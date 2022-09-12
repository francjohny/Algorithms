package leetcode.nine.zero.four;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int i = 0, j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (; i < n; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            if (map.size() > 2) {
                map.put(fruits[j], map.get(fruits[j]) - 1);
                map.remove(fruits[j], 0);
                j++;
            }
        }
        return i - j;
    }
}
