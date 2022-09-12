package leetcode.one.seven.nine.zero;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int swaps = 0;
        char ch1 = '\0', ch2 = '\0';
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (swaps > 2) {
                    return false;
                }
                if (swaps == 0) {
                    swaps++;
                    ch1 = s1.charAt(i);
                    ch2 = s2.charAt(i);
                } else {
                    if (s1.charAt(i) == ch2 && s2.charAt(i) == ch1) {
                        swaps++;
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return swaps == 0 || swaps == 2;
    }
}

