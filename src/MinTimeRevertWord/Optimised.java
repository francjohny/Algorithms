package MinTimeRevertWord;

import java.util.Arrays;

public class Optimised {
    public static int minimumTimeToInitialState(String word, int k) {
        int n = word.length(), len = 0;
        // arr[i] - length of the longest prefix that is also the longest suffix
        int[] arr = new int[n];
        for(int i = 1; i < n;) {
            if (word.charAt(i) == word.charAt(len)) {
                arr[i++] = ++len;
            } else {
                if (len > 0)
                    len = arr[len - 1];
                else
                    i++;
            }
        }
        while (len > 0 && (n - len) % k > 0) {
            len = arr[len - 1];
        }
        return (n - len + k - 1) / k;
    }

    public static void main(String[] args) {
        System.out.println(Optimised.minimumTimeToInitialState("abcbdabc", 2));
    }
}
