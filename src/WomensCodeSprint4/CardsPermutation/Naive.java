package WomensCodeSprint4.CardsPermutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

// does not work for large data sets [unaccepted]
public class Naive {
    private static int count = 0;
    private static HashMap<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder str = new StringBuilder(n);
        IntStream.range(1, n + 1).boxed().forEach(str::append);
        permutation("", str.toString());
        // get the sum of the count of all strings in hashmap which matches pattern *
        StringBuilder pattern = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int anInt = in.nextInt();
            if (anInt == 0) {
                pattern.append(".+");
            } else {
                pattern.append(anInt);
            }
        }
        List<String> allMatches = new ArrayList<>();
        hashMap.keySet().forEach(s -> {
            Matcher m = Pattern.compile(pattern.toString()).matcher(s);
            while (m.find()) {
                allMatches.add(m.group());
            }
        });
        long sum = 0;
        for (String string : allMatches) {
            sum += (hashMap.get(string) % (Math.pow(10, 9) + 7));
        }
        System.out.println(sum);
    }

    private static int permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            count++;
            hashMap.put(prefix, count);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
        return count;
    }
}
