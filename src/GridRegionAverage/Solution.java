package GridRegionAverage;

import java.util.Arrays;

class Solution {
    public static int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length;
        int n = image[0].length;
        int[][][] result = new int[m][n][2];
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                boolean isRegion = true;
                int sum = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        sum += image[k][l];
                        isRegion &= (l == j) || Math.abs(image[k][l] - image[k][l - 1]) <= threshold;
                        isRegion &= (k == i) || Math.abs(image[k][l] - image[k - 1][l]) <= threshold;
                    }
                }
                if (isRegion) {
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            result[k][l][0] += sum / 9;
                            result[k][l][1]++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j][1] > 0) {
                    image[i][j] = result[i][j][0] / result[i][j][1];
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(Solution.resultGrid(new int[][]
                {
                        {5, 6, 7, 10},
                        {8,9,10,10},
                        {11,12,13,10}
                }, 3)));
    }
}