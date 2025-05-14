package leetcode.three.three.four.three;

import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX = 20; // max length of num
    static long[] fact = new long[MAX + 1];
    static long[] invFact = new long[MAX + 1];

    // Precompute factorials and inverse factorials
    static {
        fact[0] = 1;
        for (int i = 1; i <= MAX; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[MAX] = modinv(fact[MAX]);
        for (int i = MAX - 1; i >= 0; i--) invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }

    // Modular inverse using Fermat's little theorem
    static long modinv(long x) {
        return pow(x, MOD - 2);
    }

    // Fast exponentiation
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
        int n = num.length();
        int[] freq = new int[10];
        for (char c : num.toCharArray()) freq[c - '0']++;

        int evenCount = (n + 1) / 2;
        int oddCount = n / 2;

        Map<String, Long> dp = new HashMap<>();
        return (int) dfs(0, freq, new int[10], new int[10], evenCount, oddCount, 0, dp);
    }

    // pos: current digit (0-9)
    // freq: original frequency of each digit
    // evenFreq: how many of each digit assigned to even slots
    // oddFreq: how many of each digit assigned to odd slots
    // evenLeft: how many even slots left
    // oddLeft: how many odd slots left
    // diff: current sum difference (evenSum - oddSum)
    // dp: memoization
    private long dfs(int pos, int[] freq, int[] evenFreq, int[] oddFreq, int evenLeft, int oddLeft, int diff, Map<String, Long> dp) {
        if (pos == 10) {
            if (evenLeft == 0 && oddLeft == 0 && diff == 0) {
                long ways = multinomial(evenFreq) * multinomial(oddFreq) % MOD;
                return ways;
            }
            return 0;
        }
        String key = pos + "," + evenLeft + "," + oddLeft + "," + diff + "," + Arrays.toString(evenFreq) + "," + Arrays.toString(oddFreq);
        if (dp.containsKey(key)) return dp.get(key);

        long res = 0;
        for (int useEven = 0; useEven <= freq[pos] && useEven <= evenLeft; useEven++) {
            int useOdd = freq[pos] - useEven;
            if (useOdd > oddLeft) continue;
            evenFreq[pos] += useEven;
            oddFreq[pos] += useOdd;
            int newDiff = diff + useEven * pos - useOdd * pos;
            res = (res + dfs(pos + 1, freq, evenFreq, oddFreq, evenLeft - useEven, oddLeft - useOdd, newDiff, dp)) % MOD;
            evenFreq[pos] -= useEven;
            oddFreq[pos] -= useOdd;
        }
        dp.put(key, res);
        return res;
    }

    // Multinomial coefficient: n! / (a1! * a2! * ... * ak!)
    private long multinomial(int[] freq) {
        int total = 0;
        for (int f : freq) total += f;
        long res = fact[total];
        for (int f : freq) res = res * invFact[f] % MOD;
        return res;
    }
}