package ShortestPalindrome;

import java.util.Scanner;

// FIXME
public class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int mid = n / 2, left = mid - 1, right = n % 2 == 0 ? mid : mid + 1;
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int r = n - 1;
        StringBuilder sb = new StringBuilder();
        while(r >= left) {
            sb.append(s.charAt(r));
            r--;
        }
        sb.append(s, 0, left + 1).append(s.substring(right));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestPalindrome(new Scanner(System.in).next()));
    }
}
