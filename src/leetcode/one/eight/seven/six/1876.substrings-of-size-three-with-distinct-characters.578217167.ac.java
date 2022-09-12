package leetcode.one.eight.seven.six;

class Solution {
    public int countGoodSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for (int j = 0; j + 2 < n; j++) {
            if (s.charAt(j) != s.charAt(j+1) && s.charAt(j+1) != s.charAt(j+2) && s.charAt(j) != s.charAt(j+2)) {
                res++;
            }
        }
        return res;
    }
}
