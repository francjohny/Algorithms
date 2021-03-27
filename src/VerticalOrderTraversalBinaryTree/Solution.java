package VerticalOrderTraversalBinaryTree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>(Comparator.naturalOrder());
        dfs(root, 0, 0);
        List<List<Integer>> verticals = new ArrayList<>();
        for (int col: map.keySet()) {
            List<Integer> levels = new ArrayList<>();
            for (List<Integer> list : map.get(col).values()) {
                Collections.sort(list);
                levels.addAll(list);
            }
            verticals.add(levels);
        }
        return verticals;
    }

    private void dfs(TreeNode root, int level, int x) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(x, new TreeMap<>());
        map.get(x).putIfAbsent(level, new ArrayList<>());
        map.get(x).get(level).add(root.val);
        dfs(root.left, level + 1, x -1);
        dfs(root.right, level + 1, x + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        new Solution().verticalTraversal(root);
    }
}