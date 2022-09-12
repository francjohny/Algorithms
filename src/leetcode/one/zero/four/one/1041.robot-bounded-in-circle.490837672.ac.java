package leetcode.one.zero.four.one;

class Solution {
    public boolean isRobotBounded(String instructions) {
        // (y, x) => up(0), right(1), down(2), left(3)
        int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int direction = 0, x = 0, y = 0;
        for (char ch: instructions.toCharArray()) {
            if (ch == 'L') {
                direction = (direction + 3) % 4;
            } else if (ch == 'R') {
                direction = (direction + 1) % 4;
            } else {
                y += directions[direction][0];
                x += directions[direction][1];
            }
        }
        if ((x == 0 && y == 0) || direction > 0) {
            return true;
        }
        return false;
    }
}
