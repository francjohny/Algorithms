package leetcode.eight.three.eight;

class Solution {
    public String pushDominoes(String dominoes) {
        dominoes = 'L' + dominoes + 'R';  // Add boundary dominoes to handle edge cases
        StringBuilder output = new StringBuilder(dominoes);
        int left = 0, right = 1;
        
        while (right < output.length()) {
            while (right < output.length() && output.charAt(right) == '.') {
                right++;
            }
            
            if (right >= output.length()) break;
            
            char leftChar = output.charAt(left);
            char rightChar = output.charAt(right);
            
            if (leftChar == rightChar) {
                // Fill everything between with the same character
                for (int i = left + 1; i < right; i++) {
                    output.setCharAt(i, leftChar);
                }
            } else if (leftChar == 'R' && rightChar == 'L') {
                // Handle R...L case
                int len = right - left - 1;
                for (int i = 1; i <= len/2; i++) {
                    output.setCharAt(left + i, 'R');
                    output.setCharAt(right - i, 'L');
                }
            }
            // For L...R case, do nothing as dominoes stay vertical
            
            left = right;
            right++;
        }
        
        // Return without the boundary dominoes we added
        return output.substring(1, output.length() - 1);
    }
}