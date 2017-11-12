package TriesContacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

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
 *
 *
 * Optimised by storing the number of words from a prefix on insertion.
 * Hence, to find the number of words starting with a prefix is just O(1).
 */

class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isCompletedWord;
    int size;

    TrieNode(HashMap<Character, TrieNode> children) {
        this.children = children;
        this.isCompletedWord = false;
        this.size = 0;
    }
}

public class Optimised {
    private TrieNode root;

    public static void main(String[] args) {
        Optimised trie = new Optimised();
        trie.root = new TrieNode(new HashMap<>());
        FastIO in = new FastIO();
        int n = in.getInt();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            switch (op) {
                case "add":
                    insert(trie.root, contact);
                    break;
                case "find":
                    int count = find(trie.root, contact);
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
            root.size += 1;
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
        return root.size;
    }

}

class FastIO {
    private BufferedReader br;
    private StringTokenizer stringTokenizer;

    public FastIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        try {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringTokenizer.nextToken();
    }

    public int getInt() {
        return Integer.parseInt(next());
    }

    public long getLong() {
        return Long.parseLong(next());
    }

}
