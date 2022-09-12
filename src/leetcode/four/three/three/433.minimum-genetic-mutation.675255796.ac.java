package leetcode.four.three.three;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return -1;
        }
        int mutations = 0;
        Deque<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        char[] choices = new char[]{'A', 'C', 'G', 'T'};
        for(String b: bank) {
            set.add(b);
        }
        if (set.isEmpty()) {
            return -1;
        }
        queue.offer(start);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                String elem = queue.poll();
                if (elem.equals(end)) {
                    return mutations;
                }
                char[] node = elem.toCharArray();
                for(int j = 0; j < node.length; j++) {
                    char old = node[j];
                    for(char choice: choices) {
                        node[j] = choice;
                        String newElem = new String(node);
                        if (set.contains(newElem)) {
                            queue.offer(newElem);
                            set.remove(newElem);
                        }
                    }
                    node[j] = old;
                }
            }
            mutations++;
        }
        return -1;
    }
}

// there might be start characters which do not match the end string in the bank which will eventually match the end string
// hence iterate over each possible start + replaced character and check if in the bank
// bfs / level order traversal as we can replace atmost one character in each step
