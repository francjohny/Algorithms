package CompressedVectorProduct;

public class Solution {
    public int solve(int[] a, int[] b) {
        int result = 0, ptr1 = 0, ptr2 = 0;
        while (ptr1 < a.length && ptr2 < b.length) {
            int min = Math.min(a[ptr1], b[ptr2]);
            result += min * a[ptr1 + 1] * b[ptr2 + 1];
            a[ptr1] -= min;
            b[ptr2] -= min;
            if (a[ptr1] == 0) {
                ptr1 += 2;
            }
            if (b[ptr2] == 0) {
                ptr2 += 2;
            }
        }
        return result;
    }
}
