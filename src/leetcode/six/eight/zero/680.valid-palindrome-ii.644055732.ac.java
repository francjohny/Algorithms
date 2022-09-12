package leetcode.six.eight.zero;

class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrom(s, 0, s.length() - 1, 0);
    }
    
    private boolean validPalindrom(String s, int start, int end, int deleteCount) {
        if (deleteCount > 1) {
            return false;
        }
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return validPalindrom(s, start + 1, end, deleteCount + 1) || validPalindrom(s, start, end - 1, deleteCount + 1);
            }
            start++;
            end--;
        }
     return true;   
    }
}
