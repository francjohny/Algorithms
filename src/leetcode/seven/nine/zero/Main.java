package leetcode.seven.nine.zero;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testCases = {29, 30};
        for (int n : testCases) {
            int result = solution.numTilings(n);
            System.out.println("n = " + n + ", ways = " + result);
        }
    }
} 