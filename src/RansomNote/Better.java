package RansomNote;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Better {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        List<String> magazine = new ArrayList<>(m);
        while(m-- > 0) {
            String str = in.next();
            magazine.add(str);
        }
        Map<String, Long> wordFreq = magazine.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(check(wordFreq, n, in));
    }

    private static String check(Map<String, Long> magazine, int n, Scanner in) {
        final String YES = "Yes";
        final String NO = "No";
        while (n-- > 0) {
            String str = in.next();
            magazine.computeIfPresent(str, (s, freq) -> freq - 1);
            if (magazine.get(str) < 0)
                return NO;
        }
        return YES;
    }
}
