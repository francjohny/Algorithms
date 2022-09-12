package leetcode.two.two.two.four;

class Solution {
    public int convertTime(String current, String correct) {
        String[] c1 = current.split(":");
        String[] c2 = correct.split(":");
        int diff = (Integer.parseInt(c2[0]) * 60 + Integer.parseInt(c2[1])) - (Integer.parseInt(c1[0]) * 60 + Integer.parseInt(c1[1]));
        int[] mins = new int[]{60, 15, 5, 1};
        int ops = 0;
        for(int min: mins) {
            if (diff >= min) {
                ops += diff / min;
                diff = diff % min;
            }
        }
        return ops;
    }
}
