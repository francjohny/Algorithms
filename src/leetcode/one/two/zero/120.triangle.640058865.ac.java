package leetcode.one.two.zero;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                List<Integer> current = triangle.get(i + 1);
                List<Integer> previous = triangle.get(i);
                previous.set(j, previous.get(j) + Math.min(current.get(j), current.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
