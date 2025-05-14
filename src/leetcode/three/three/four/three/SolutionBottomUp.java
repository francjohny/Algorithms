package leetcode.three.three.four.three;

import java.util.*;

class SolutionBottomUp {
    static final int MOD = 1_000_000_007;
    static final int MAX = 80;
    static long[] fact = new long[MAX + 1];
    static long[] invFact = new long[MAX + 1];

    static {
        fact[0] = 1;
        for (int i = 1; i <= MAX; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[MAX] = modinv(fact[MAX]);
        for (int i = MAX - 1; i >= 0; i--) invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }

    static long modinv(long x) {
        return pow(x, MOD - 2);
    }

    static long pow(long x, long n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) res = res * x % MOD;
            x = x * x % MOD;
            n >>= 1;
        }
        return res;
    }

    public int countBalancedPermutations(String num) {
        int totalSum = 0;
        for (char c : num.toCharArray()) totalSum += c - '0';
        if (totalSum % 2 != 0) return 0;

        int n = num.length();
        int[] freq = new int[10];
        for (char c : num.toCharArray()) freq[c - '0']++;
        int evenCount = (n + 1) / 2;
        int oddCount = n / 2;
        int maxDiff = n * 9;
        int offset = maxDiff * (n / 2 + 1); // to handle negative diffs

        // dp[digit][evenLeft][oddLeft][diff] = number of ways to assign digits 0..digit-1
        // We'll use two layers for space
        Map<String, Long> dp = new HashMap<>();
        // Initial state: before assigning any digits, all slots left, diff 0
        dp.put(evenCount + "," + oddCount + "," + offset, 1L);

        for (int digit = 0; digit < 10; digit++) {
            Map<String, Long> next = new HashMap<>();
            int cnt = freq[digit];
            for (Map.Entry<String, Long> entry : dp.entrySet()) {
                String[] parts = entry.getKey().split(",");
                int e = Integer.parseInt(parts[0]);
                int o = Integer.parseInt(parts[1]);
                int d = Integer.parseInt(parts[2]);
                long ways = entry.getValue();
                // Try all ways to split cnt between even and odd slots
                for (int evenSlots = 0; evenSlots <= cnt && evenSlots <= e; evenSlots++) {
                    int oddSlots = cnt - evenSlots;
                    if (oddSlots > o) continue;
                    int newE = e - evenSlots;
                    int newO = o - oddSlots;
                    int newD = d + evenSlots * digit - oddSlots * digit;
                    long addWays = ways * C(e, evenSlots) % MOD * C(o, oddSlots) % MOD;
                    String key = newE + "," + newO + "," + newD;
                    next.put(key, (next.getOrDefault(key, 0L) + addWays) % MOD);
                }
            }
            dp = next;
        }

        // Now, for all assignments with evenLeft=0, oddLeft=0, diff=offset, count the arrangements
        long res = dp.getOrDefault("0,0," + offset, 0L);
        return (int) res;
    }

    static long C(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }
}