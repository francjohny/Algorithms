package leetcode.six.zero.six;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public String tree2str(TreeNode root) {
        return dfs(root, new StringBuilder());
    }

    private String dfs(TreeNode root, StringBuilder sb) {
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            return sb.toString();
        }
        if (root.left != null) {
            sb.append("(");
            dfs(root.left, sb);
            sb.append(")");
        } else {
            sb.append("()");
        }
        if (root.right != null) {
            sb.append("(");
            dfs(root.right, sb);
            sb.append(")");
        }
        return sb.toString();
    }
}
