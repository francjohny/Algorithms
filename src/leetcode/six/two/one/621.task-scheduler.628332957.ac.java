package leetcode.six.two.one;

import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        char[] counter = new char[26];
        int max = 0;
        for(char ch: tasks) {
            counter[ch - 'A']++;
            max = Math.max(max, counter[ch - 'A']);
        }
        Arrays.sort(counter);
        int ans = (max - 1) * (n + 1);
        int i = 25;
         while (i >= 0 && counter[i--] == max) {
             ans++;
         }
        return Math.max(tasks.length, ans);
    }
}
