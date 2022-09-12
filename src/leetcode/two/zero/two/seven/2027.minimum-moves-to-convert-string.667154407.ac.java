package leetcode.two.zero.two.seven;

class Solution {
    public int minimumMoves(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int moves = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'X') {
                moves++;
                i += 2;
            }
        }
        return moves;
    }
}
