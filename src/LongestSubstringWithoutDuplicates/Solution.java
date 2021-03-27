package LongestSubstringWithoutDuplicates;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), low = 0, high = low, max = 1;
        if (n == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        while (high < n) {
            Character ch = s.charAt(high);
            if (map.containsKey(ch))  {
                low = Math.max(low, map.get(ch) + 1);
            }
            map.put(ch, high);
            max = Math.max(high - low + 1, max);
            high++;
        }
        return max;
    }
}
