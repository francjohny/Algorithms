package LongestCommonSuffixQueries;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    static class TrieNode {

        char ch;
        TrieNode[] children;
        boolean isEndOfWord;
        int index;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
            index = -1;
        }

        private static void insert(TrieNode root, String[] wordsContainer) {
            for(int idx = 0; idx < wordsContainer.length; idx++) {
                TrieNode node = root;
                String str = wordsContainer[idx];
                for(int i = str.length() - 1; i >= 0; i--) {
                    char ch = str.charAt(i);
                    int c = ch - 'a';
                    if (node.children[c] == null) {
                        node.children[c] = new TrieNode();
                        node.children[c].ch = ch;
                    }
                    node = node.children[c];
                    if (node.index == -1 || str.length() < wordsContainer[node.index].length())
                        node.index = idx;
                }
                node.isEndOfWord = true;
            }
        }

        private static int[] find(TrieNode root, String[] wordsQuery) {
            int[] ans = new int[wordsQuery.length];
            for (int i = 0; i < wordsQuery.length; i++) {
                TrieNode node = root;
                String q = wordsQuery[i];
                for(int j = q.length() - 1; j >= 0; j--) {
                    char ch = q.charAt(j);
                    int c = ch - 'a';
                    if (node.children[c] != null) {
                        node = node.children[c];
                    } else {
                        break;
                    }
                }
                ans[i] = node.index;
            }
            return ans;
        }
    }

    public static int findIndexOfSmallest(String[] arr) {
        int smallestIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() < arr[smallestIdx].length()) {
                smallestIdx = i;
            }
        }
        return smallestIdx;
    }

    public static int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();
        root.index = findIndexOfSmallest(wordsContainer);
        TrieNode.insert(root, wordsContainer);
        return TrieNode.find(root, wordsQuery);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(stringIndices(new String[]{"abcd", "bcd", "xbcd"}, new String[]{"cd", "bcd", "xyz"})));
        System.out.println(Arrays.toString(stringIndices(new String[]{"abcdefgh","poiuygh","ghghgh"}, new String[]{"gh","acbfgh","acbfegh"})));
    }
}
