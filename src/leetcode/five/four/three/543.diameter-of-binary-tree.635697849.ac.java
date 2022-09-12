package leetcode.five.four.three;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private int getMaxDiameter(TreeNode root, int[] result) {
        if (root == null) {
            return -1;
        }
        int left = getMaxDiameter(root.left, result);
        int right = getMaxDiameter(root.right, result);
        result[0] = Math.max(result[0], left + right + 2);
        return 1 + Math.max(right, left);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[1];
        getMaxDiameter(root, result);
        return result[0];
    }
}
