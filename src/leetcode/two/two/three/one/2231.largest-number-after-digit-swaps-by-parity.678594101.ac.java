package leetcode.two.two.three.one;

class Solution {
    public int largestInteger(int num) {
        if (num > 0 && num < 10) return num;
        int[] freq = new int[10];
        for(int i = num; i > 0; i /= 10) {
            freq[i % 10]++;
        }
        int result = 0;
        int[] parity = new int[]{0, 1};
        for(int i = num, mul = 1; i > 0; i /= 10, mul *= 10) {
            int rem = i % 10 % 2;
            while(freq[parity[rem]] == 0) {
                parity[rem] += 2;
            }
            freq[parity[rem]]--;
            result += mul * parity[rem];
        }
        
        return result;
    }
}
