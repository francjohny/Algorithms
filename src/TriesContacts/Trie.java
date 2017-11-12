package TriesContacts;

import java.util.HashMap;
import java.util.Scanner;

/*
 * We're going to make our own Contacts application! The application must perform two types of operations:
 * `add name`, where `name` is a string denoting a contact name. This must store `name` as a new contact in the application.
 * `find partial`, where `partial` is a string denoting a partial name to search the application for.
 * It must count the number of contacts starting with `partial` and print the count on a new line.
 *
 * Given  sequential add and find operations, perform each operation in order.
 *
 * Input:
 * 4
 * add hack
 * add hackerrank
 * find hac
 * find hak
 *
 * Output:
 * 2
 * 0
 */
class Node {
    HashMap<Character, TrieNode> children;
    boolean isCompletedWord;

    Node(HashMap<Character, TrieNode> children) {
        this.children = children;
        this.isCompletedWord = false;
    }
}

public class Trie {
    private TrieNode root;

    private static int count = 0;

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.root = new TrieNode(new HashMap<>());
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            count = 0;
            switch (op) {
                case "add":
                    insert(trie.root, contact);
                    break;
                case "find":
                    count = find(trie.root, contact);
                    System.out.println(count);
                    break;
            }
        }
    }

    private static void insert(TrieNode root, String contact) {
        for (int i = 0; i < contact.length(); i++) {
            Character character = contact.charAt(i);
            root.children.computeIfAbsent(character, k -> new TrieNode(new HashMap<>()));
            root = root.children.get(character);
        }
        root.isCompletedWord = true;
    }

    private static int find(TrieNode root, String prefix) {
        for (int i = 0; i < prefix.length(); i++) {
            char character = prefix.charAt(i);
            if (root.children.get(character) == null)
                return 0;
            root = root.children.get(character);
        }
        return findNumberOfCompletedWords(root);
    }

    private static int findNumberOfCompletedWords(TrieNode root) {
        if (root.isCompletedWord)
            count += 1;
        for (Character character : root.children.keySet())
            findNumberOfCompletedWords(root.children.get(character));
        return count;
    }
}
