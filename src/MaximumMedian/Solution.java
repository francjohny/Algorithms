package MaximumMedian;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        List<Long> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(Long.parseUnsignedLong(in.next()));
        }
        Collections.sort(a);
        Long current = a.get(n / 2);
        for (int i = n / 2 + 1; i <= n; i++) {
            long gap = i == n ? Long.MAX_VALUE : a.get(i) - current;
            long add = Math.min(gap, k / (i - n / 2));
            current = Long.parseUnsignedLong(String.valueOf(current + add));
            k -= add * (i - n / 2);
        }
        System.out.println(current);
    }
}