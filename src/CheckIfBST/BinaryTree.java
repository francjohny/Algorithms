package CheckIfBST;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

/*
 * we define a binary search tree to be a binary tree with the following ordering properties:
 * The data value of every node in a node's left subtree is less than the data value of that node
 * The data value of every node in a node's right subtree is greater than the data value of that node.
 *
 * Given the root node of a binary tree, can you determine if it's also a binary search tree?
 */
public class BinaryTree {
    private Node root;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(4);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(6);
        binaryTree.root.left.left = new Node(1);
        binaryTree.root.left.right = new Node(3);
        binaryTree.root.right.left = new Node(5);
        binaryTree.root.right.right = new Node(7);
        checkIfBST(binaryTree.root);

        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree1.root = new Node(3);
        binaryTree1.root.left = new Node(2);
        binaryTree1.root.right = new Node(5);
        binaryTree1.root.left.left = new Node(1);
        binaryTree1.root.left.right = new Node(4);
        checkIfBST(binaryTree1.root);
    }

    private static void checkIfBST(Node root) {
        boolean isBST = check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (isBST)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    /*
     * To check if a tree is a bst,
     * 1) check if the left subtree of the tree is a bst and
     * 2) check if the right subtree of the tree is a bst
     */
    private static boolean check(Node root, int minValue, int maxValue) {
        if (root == null)
            return true;
        if (root.data >= maxValue || root.data <= minValue)
            return false;
        return check(root.left, minValue, root.data) && check(root.right, root.data, maxValue);
    }
}
