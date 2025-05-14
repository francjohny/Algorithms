package leetcode.one.one.two.eight;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int[] domino : dominoes) {
            int a = Math.min(domino[0], domino[1]);
            int b = Math.max(domino[0], domino[1]);
            int key = a * 10 + b;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int count : map.values()) {
            if (count > 1) {
                result += count * (count - 1) / 2;
            }
        }
        return result;
    }
}
