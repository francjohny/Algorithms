package MakingAnagrams;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Alice is taking a cryptography class and finding anagrams to be very useful.
 * We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string.
 * In other words, both strings must contain the same exact letters in the same exact frequency
 * For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.
 * Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams.
 * Can you help her find this number?
 * Given two strings, a and b, that may or may not be of the same length, determine the minimum number of character deletions required to make a and b anagrams.
 * Any characters can be deleted from either of the strings.
 *
 * Input:
 * cde
 * abc
 *
 * Output:
 * 4
 */
public class Naive {
    private static int numberNeeded(String first, String second) {
        HashMap<Character, Integer> letterFrequency = new HashMap<>(26);
        for (Character character : first.toCharArray()) {
            letterFrequency.put(character, letterFrequency.getOrDefault(character, 0) + 1);
        }
        for (Character character : second.toCharArray()) {
            letterFrequency.put(character, letterFrequency.getOrDefault(character, 0) - 1);
        }
        return letterFrequency.values().stream()
                .reduce(0, (integer, integer2) -> Math.abs(integer) + Math.abs(integer2));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

