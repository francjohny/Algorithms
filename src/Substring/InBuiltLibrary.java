package Substring;

import IO.FastIO;

import java.text.NumberFormat;
import java.util.*;

public class InBuiltLibrary {
    public static void main(String[] args) {
        FastIO fastIO = new FastIO();
        System.out.println("Enter a function to perform: ");
        System.out.println(String.join("", Collections.nCopies(40, "-")));
        System.out.println("1. Substring");
        System.out.println("2. Currency");
        System.out.println("3. Anagram");
        System.out.println("4. Frequency of words in a sentence");
        System.out.println(String.join("", Collections.nCopies(40, "-")));
        int choice = fastIO.getInt();
        switch (choice) {
            case 1:
                String text = fastIO.next();
                String pattern = fastIO.next();
                // 1. substring - if T' is a cyclic rotation of T, then T' is contained in TT
                if (text.indexOf(pattern) > 0) // text.contains(pattern)
                    System.out.println("Substring");
                else
                    System.out.println("Not a substring");
                break;
            case 2:
                // 2. get currency in any locale
                long number = fastIO.getLong();
                System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).format(number));
                break;
            case 3:
                // 3. anagram
                String x = fastIO.next();
                String y = fastIO.next();
                char[] xchars = x.toCharArray();
                char[] ychars = y.toCharArray();
                Arrays.sort(xchars);
                Arrays.sort(ychars);
                HashSet<Object> set = new HashSet<>();
                set.add(new String(xchars));
                set.add(new String(ychars));
                if (set.size() == 1)
                    System.out.println("anagrams");
                else
                    System.out.println("Not anagrams");
                break;
            case 4:
                // sets, maps
                String[] splitWords = fastIO.nextLine().split(" ", -1);

                HashSet<String> hashSet = new HashSet<>(); // order depends on hash code
                TreeSet<String> treeSet = new TreeSet<>(); // sorts alphabetically
                LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(); // preserves order

                HashMap<String, Integer> hashMap = new HashMap<>(); // order depends on hash code
                TreeMap<String, Integer> treeMap = new TreeMap<>(); // sorts alphabetically
                LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(); // preserves order

                for (String word: splitWords) {
                    Integer count = hashMap.get(word);
                    hashMap.put(word, count == null ? 1 : count + 1);
                    treeMap.put(word, count == null ? 1 : count + 1);
                    linkedHashMap.put(word, count == null ? 1 : count + 1);

                    hashSet.add(word);
                    treeSet.add(word);
                    linkedHashSet.add(word);
                }

                System.out.println(hashMap);
                System.out.println(treeMap);
                System.out.println(linkedHashMap);

                System.out.println(hashSet);
                System.out.println(treeSet);
                System.out.println(linkedHashSet);
        }
    }

}
