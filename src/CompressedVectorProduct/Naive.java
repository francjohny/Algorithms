package CompressedVectorProduct;

class Naive {
    public int solve(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        if (n == 1 || m == 1 || n % 2 != 0 || m % 2 != 0) {
            return 0;
        }
        int sum1 = 0;
        for (int i = 0; i < n; i+=2) {
            sum1 += a[i];
        }
        int sum2 = 0;
        for (int i = 0; i < m; i+=2) {
            sum2 += b[i];
        }
        if (sum1 != sum2) {
            return 0;
        }
        int result = 0;
        int ctr1 = 1, ctr2 = 1;
        int k = a[ctr1 - 1];
        int l = b[ctr2 - 1];
        while(ctr1 < n || ctr2 < m) {
            while(k > 0 && l > 0) {
                result += a[ctr1] * b[ctr2];
                l--;
                k--;
            }
            if (k == 0) {
                ctr1 += 2;
                if (ctr1 < n )
                    k = a[ctr1 - 1];
            }
            if (l == 0) {
                ctr2 += 2;
                if (ctr2 < m)
                    l = b[ctr2 - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Naive().solve(new int[]{4, 1, 5, 2}, new int[]{9, 2}));
    }
}