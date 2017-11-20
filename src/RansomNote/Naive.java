package RansomNote;

import java.util.HashMap;
import java.util.Scanner;

/*
 * A kidnapper wrote a ransom note but is worried it will be traced back to him.
 * He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note.
 * The words in his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot use substrings or concatenation to create the words he needs.
 * Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
 *
 * Input 1:
 * 6 4
 * give me one grand today night
 * give one grand today
 *
 * Output 1:
 * Yes
 *
 * Input 2:
 * 6 5
 * two times three is not four
 * two times two is four
 *
 * Output 2:
 * No
 */
public class Naive {
    public static void main(String[] args) {
        final String YES = "Yes";
        final String NO = "No";
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        HashMap<String, Integer> magazine = new HashMap<>(m);
        HashMap<String, Integer> notes = new HashMap<>(n);
        while(m-- > 0) {
            String str = in.next();
            Integer count = magazine.get(str);
            magazine.put(str, count == null ? 1 : count + 1);
        }
        while (n-- > 0) {
            String str = in.next();
            Integer count = notes.get(str);
            notes.put(str, count == null ? 1 : count + 1);
        }

        notes.keySet().removeIf(note -> notes.get(note) - magazine.getOrDefault(note, 0) <= 0);
        if (notes.size() > 0)
            System.out.println(NO);
        else
            System.out.println(YES);
    }
}
