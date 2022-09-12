package leetcode.two.two.one.seven;// 101 = 1(10^(len / 2 = 1)) + 0 (query - 1 = 0) + 1 (reverse)
// 111
// 121 = 1() + 2 (query - 1 = 2) + 1 (reverse)
// ...
// 191
// 202 = 2() + 0 (query - 1 = 10) + 2 (reverse)

// 10001  = 
// 10101
// 10201
// ...
// 10901
// 11011 = 11 + 0 + 11
// 12021 = 12 + 0 + 21
// ...
// 19091
// 20002
// 21012
// ...
// 29092

class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] result = new long[n];
        for(int i = 0; i < n; i++) {
            int query = queries[i];
            String ans = getPalindrome(query - 1, intLength);
            if (ans.length() > intLength) {
                ans = "-1";
            }
            result[i] = Long.parseLong(ans);
        }
        return result;
    }
    
    private String getPalindrome(int n, int length) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder().append((long) Math.pow(10, ((length + 1) / 2) - 1) + n);
        sb.append(ans).append(ans.reverse().substring(length % 2));
        return sb.toString();
    }
}
