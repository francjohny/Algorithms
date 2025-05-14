package leetcode.two.zero.nine.four;

import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit]++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 100; i <= 999; i += 2) {
            int hun = i / 100, ten = i / 10 % 10, one = i % 10;
            int[] cur = new int[10];
            cur[hun]++;
            cur[ten]++;
            cur[one]++;
            boolean valid = true;
            for(int j = 0; j < 10; j++) {
                if (cur[j] > count[j]) {
                    valid = false;
                    break;
                }
            }
            if (valid) res.add(i);
        }

        int[] ans = res.stream().mapToInt(x -> x).toArray();
        return ans;
    }
}