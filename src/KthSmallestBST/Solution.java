package KthSmallestBST;

class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public static void kthSmallest(TreeNode root, int k) {
            System.out.println(dfs(root, k, new int[1]));
        }

        private static int dfs(TreeNode root, int k, int[] count) {
            if (root == null)
                return 0;
            int result = dfs(root.left, k, count);
            if (result != 0) {
                return result;
            }
            count[0]++;
            if (k == count[0]) {
                return root.val;
            }
            return dfs(root.right, k, count);
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.left.right = new TreeNode(3);
            root.right = new TreeNode(5);
            kthSmallest(root, 1);
        }
    }

