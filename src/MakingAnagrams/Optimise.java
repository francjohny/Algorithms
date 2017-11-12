package MakingAnagrams;

import java.util.Arrays;
import java.util.Scanner;

public class Optimise {
    private static int numberNeeded(String first, String second) {
        int letterFrequency[] = new int[26];
        for (Character character : first.toCharArray()) {
            letterFrequency[character - 'a']++;
        }
        for (Character character : second.toCharArray()) {
            letterFrequency[character - 'a']--;
        }
        return Arrays.stream(letterFrequency).reduce(0, (a, b) -> Math.abs(a) + Math.abs(b));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

