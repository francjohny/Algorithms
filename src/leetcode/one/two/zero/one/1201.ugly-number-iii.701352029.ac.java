package leetcode.one.two.zero.one;

class Solution {
    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
    
    private long lcm(long a, long b, long c) {
        return lcm(lcm(a, b), c);
    }
    
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = 1, high = 2 * (long)1e9;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if ((mid/a + mid/b + mid/c - mid/lcm(a,b) - mid/lcm(b,c) - mid/lcm(a,c) + mid/lcm(a, b, c)) >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }
}

// no. of elements divisible by a = x
// no. of elements divisible by b = y
// no. of elements divisible by c = z
// no. of elements divisible by a and b = xy
// no. of elements divisible by b and c = yz
// no. of elements divisible by c and a = zx
// no. of elements divisible by a, b, and c = xyz

// ∑(a U b U c) = ∑(a) + ∑(b) + ∑(c) - ∑(a ints. b) - ∑(b ints. c) - ∑(c ints. a) + ∑(a ints. b ints. c)
//              = x + y + z - xy - yz - zx + xyz


