package leetcode.nine.one;

class Solution {
    // Time complexity: O(n), where n - length of s
    // Space complexity: O(1)
    public int numDecodings(String s) {
        int n = s.length();
        int a = 0, b = 1, c;
        for (int i = n - 1; i >= 0; i--) {
            c = s.charAt(i) == '0' ? 0 : b;
            if (i + 1 < n && (s.charAt(i) == '1' && s.charAt(i + 1) <= '9' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
                c = c + a; // 1 1 2 3 5 8 13
            }              //          a b c 
            a = b;
            b = c;
        }
        return b;
    }
}

// climbing stairs with 1 or 2 steps at a time
// 1[0-9]
// *
// 2[0-6]
