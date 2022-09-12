package leetcode.four.two.four;

class Solution {
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int low = 0, max = 0, maxf = 0;
        int[] count = new int[26];
        for(int high = 0; high < s.length(); high++) {
            maxf = Math.max(maxf, ++count[chars[high] - 'A']);
            if (high - low + 1 - maxf > k) {
                --count[chars[low] - 'A'];
                low++;
            }
            max = Math.max(max, high - low + 1);
        }
        return max;
    }
}
