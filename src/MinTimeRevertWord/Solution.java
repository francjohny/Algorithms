package MinTimeRevertWord;

class Solution {
    public static int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int i = 1;
        for(; i <= n; i++) {
            if (i * k >= n) {
                return i;
            }
            boolean match = true;
            for(int j = i * k; j < n; j++) {
                if (word.charAt(j) != word.charAt(j - i * k)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Solution.minimumTimeToInitialState("abcbabcd", 2));
    }
}
