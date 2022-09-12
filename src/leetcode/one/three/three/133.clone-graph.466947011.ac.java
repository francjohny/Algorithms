package leetcode.one.three.three;
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/


import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        HashMap<Integer, Node> visited = new HashMap<>();
        Node newRoot = new Node(node.val);
        visited.put(newRoot.val, newRoot);

        while (!q.isEmpty()) {
            Node n = q.poll();
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor.val)) {
                    q.offer(neighbor);
                    visited.put(neighbor.val, new Node(neighbor.val));
                }
                visited.get(n.val).neighbors.add(visited.get(neighbor.val));
            }
        }

        return newRoot;
    }
}
