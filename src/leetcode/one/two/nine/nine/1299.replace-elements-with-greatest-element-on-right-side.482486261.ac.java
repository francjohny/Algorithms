package leetcode.one.two.nine.nine;// traverse from right to left
// maintain stack of elements which are in increasing order
// [17,18,5,4,6,1]
// stack: []
// max: 18

class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = -1;
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        return arr;
    }
}
