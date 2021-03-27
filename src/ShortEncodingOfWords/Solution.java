package ShortEncodingOfWords;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    class Trie {
        Character value;
        boolean isCompletedWord;
        HashMap<Character, Trie> children;
        int size;

        Trie(char val) {
            this.value = val;
            this.children = new HashMap<>();
            this.isCompletedWord = false;
            this.size = 0;
        }
    }

    public int minimumLengthEncoding(String[] words) {
        words = new HashSet<>(Arrays.asList(words)).toArray(String[]::new);
        Arrays.sort(words, (s, t1) -> t1.length() - s.length());;
        Trie root = new Trie('#');
        // 1. add nodes to the trie
        for (String word : words) {
            Trie node = root;
            boolean isAbsent = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                Character character = word.charAt(i);
                if (!node.children.containsKey(character)) {
                    node.children.put(character, new Trie(character));
                    isAbsent = true;
                }
                node = node.children.get(character);
            }
            node.size = word.length();
            if (isAbsent) {
                node.isCompletedWord = true;
            }
        }
        // 2. count number of paths from source to leaf nodes
        int count = 0;
        for (String word : words) {
            Trie node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                Character ch = word.charAt(i);
                if (node.children.containsKey(ch)) {
                    node = node.children.get(ch);
                    if (node.isCompletedWord) {
                        count += node.size + 1;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }
}
