package leetcode.one.three.two.eight;

class Solution {
    public String breakPalindrome(String s) {
        StringBuilder str = new StringBuilder(s);
        int n = s.length();
        if (n == 1) {
            return "";
        }
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != 'a') {
                str.setCharAt(i, 'a');
                return str.toString();
            }
        }
        str.setCharAt(n-1, 'b');
        return str.toString();
    }
}
