package SuffixArray.A;

import java.util.*;
import java.util.stream.Collectors;

// Time complexity: O(nlog(n)), Space complexity: O(n^2)
public class Naive {
    public static void main(String[] args) {
        String str = new Scanner(System.in).next();
        str += '$';
        int n = str.length();
        int m = getHighestPowerOf2(n);
        Map<String, Integer> stringMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = str.substring(i) + str.substring(0, (m - n + i) % (n - 1));
            stringMap.put(s, i);
        }
        System.out.println(
                stringMap
                        .keySet()
                        .stream()
                        .sorted()
                        .map(x -> stringMap.get(x).toString())
                        .collect(Collectors.joining(" "))
        );
    }

    private static int getHighestPowerOf2(int v) {
        v--;
        v |= v >> 1;
        v |= v >> 2;
        v |= v >> 4;
        v |= v >> 8;
        v |= v >> 16;
        v++;
        return v;
    }
}
