package leetcode.seven.three;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean hasFirstZeroRow = false;
        for(int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                hasFirstZeroRow = true;
                break;
            } 
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                } 
            }
        }
        
        for(int i = 1; i < m; i++) {
            boolean rowHasZero = false;
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowHasZero = true;
                    break;
                }
            }
            for(int j = 0; j < n; j++) {
                if (rowHasZero || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int j = 0; j < n; j++) {
            if (hasFirstZeroRow) {
                matrix[0][j] = 0;
            }
        }
    }
}

