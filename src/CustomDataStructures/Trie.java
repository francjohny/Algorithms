package CustomDataStructures;

import java.util.HashMap;

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.root.addWord("happy");
        trie.root.addWord("help");
        trie.root.printWords();
    }

    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isCompleteWord;
        int size;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isCompleteWord = false;
            this.size = 0;
        }

        /* Add word to the trie, and recursively create the child nodes. */
        public void addWord(String word) {
            if (word == null || word.isEmpty())
                return;

        }

        public void printWords() {

        }

        /* Find a child node of this node that has the char argument as its data. Return null if no such child node is present in the trie. */
        public TrieNode getChild(Character character) {
            return this.children.get(character);
        }

        /* Returns whether this node represents the end of a complete word. */
        public boolean isCompleteWord() {
            return this.isCompleteWord;
        }

        /* Set whether this node is the end of a complete word. */
        public void setCompleteWord(boolean isCompleteWord) {
            this.isCompleteWord = isCompleteWord;
        }
    }
}
