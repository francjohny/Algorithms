package leetcode.seven.nine.zero;

/*
Problem: Domino and Tromino Tiling (LeetCode 790)
You have two types of tiles: a 2x1 domino shape and an L-tromino shape.
Given an integer n, return the number of ways to tile a 2xn board.
Since the answer may be very large, return it modulo 10^9 + 7.

Let dp[i] be the number of ways to completely tile a 2xi board.
Let p[i] be the number of ways to tile a 2xi board with the top-right cell (0, i-1) empty
and the bottom-right cell (1, i-1) filled.
Let q[i] be the number of ways to tile a 2xi board with the bottom-right cell (1, i-1) empty
and the top-right cell (0, i-1) filled.

By symmetry, p[i] = q[i].

Derivation of dp[i]:
A 2xi board can be completed in the following ways:
1. Add a vertical domino to a fully tiled 2x(i-1) board: dp[i-1] ways.
   [ ][V]
   [ ][V]
2. Add two horizontal dominoes to a fully tiled 2x(i-2) board: dp[i-2] ways.
   [ H H ]
   [ H H ]
3. Add an L-tromino that covers (0,i-2), (0,i-1), (1,i-1). This requires the 2x(i-1) sub-board ending at column i-2
   to be in state p[i-1] (top-right (0,i-2) empty, bottom-right (1,i-2) filled).
   [p_state][T T]
   [p_state][. T] where p_state is 2x(i-1) with (0,i-2) empty, (1,i-2) filled.
   The tromino fills (0,i-2), then (0,i-1) and (1,i-1). This view might be confusing.
   Better: to form dp[i], if the 2x(i-1) board was in state p[i-1] (meaning (0, i-2) is empty, (1, i-2) is covered):
   [.......E] + T   -> [.......T-T]
   [.......F]   T      [.......F T]
   (E=empty, F=filled for the 2x(i-1) board ending at column i-2)
   Number of ways: p[i-1].
4. Add an L-tromino similarly for q[i-1]:
   Number of ways: q[i-1].

So, dp[i] = dp[i-1] + dp[i-2] + p[i-1] + q[i-1]
Since p[i-1] = q[i-1], this becomes:
(A) dp[i] = dp[i-1] + dp[i-2] + 2*p[i-1]

Derivation of p[i]:
A 2xi board with (0,i-1) empty and (1,i-1) filled can be formed by:
1. Adding a horizontal domino to cover (1,i-2) and (1,i-1). The 2x(i-1) sub-board must have
   (0,i-2) empty and (1,i-2) filled. This is p[i-1].
   [p_state][. .]
   [p_state][H H]
2. Adding an L-tromino covering (0,i-2), (1,i-2), and (1,i-1). The 2x(i-2) sub-board
   must be fully tiled. This is dp[i-2].
   [dp_state][T .]
   [dp_state][T T]

So, (B) p[i] = p[i-1] + dp[i-2]

Simplifying to get the final recurrence for dp[i]:
From (B), we have p[i-1] = p[i-2] + dp[i-3]. Substitute this into (A):
dp[i] = dp[i-1] + dp[i-2] + 2*(p[i-2] + dp[i-3])
dp[i] = dp[i-1] + dp[i-2] + 2*p[i-2] + 2*dp[i-3]  (C)

From (A), re-written for i-1:
dp[i-1] = dp[i-2] + dp[i-3] + 2*p[i-2]
So, 2*p[i-2] = dp[i-1] - dp[i-2] - dp[i-3]. Substitute this into (C):
dp[i] = dp[i-1] + dp[i-2] + (dp[i-1] - dp[i-2] - dp[i-3]) + 2*dp[i-3]
dp[i] = dp[i-1] + dp[i-2] + dp[i-1] - dp[i-2] - dp[i-3] + 2*dp[i-3]
dp[i] = 2*dp[i-1] + dp[i-3]

Base Cases:
dp[0] = 1 (one way to tile a 2x0 board: do nothing)
dp[1] = 1 (one way: one vertical domino)
   [V]
   [V]
dp[2] = 2 (two ways: two vertical dominoes OR two horizontal dominoes)
   [V][V]  OR  [H H]
   [V][V]      [H H]

The recurrence dp[i] = 2*dp[i-1] + dp[i-3] starts being used from i=3.
For dp[3]:
dp[3] = 2*dp[2] + dp[0] = 2*2 + 1 = 5.
The 5 ways for 2x3:
VVV
VVV

HH V
HH V

V HH
V HH

T T V  (Trom L, Trom L, V)
T V V

V T T
V V T

Oops, the visual for dp[3] above has an error for trominoes.
Actual ways for 2x3 (n=3), expected 5:
1. VVV
   VVV
2. HH V
   HH V
3. V HH
   V HH
4. T T .  (L-tromino covering (0,0),(1,0),(0,1))
   T . .
     . T T (L-tromino covering (1,1),(0,2),(1,2))
This is incorrect for dp[3]. Let's list the shapes.
   dp[3] = 5 ways.
   1. III (three vertical dominoes)
   2. =I (two horizontal, one vertical)
      =I
   3. I= (one vertical, two horizontal)
      I=
   4. Tromino + Domino (L-shape tromino uses 3 cells, the remaining 3 cells by other tromino or dominoes)
      T T V  ->  This is not a valid tiling if T T is a horizontal domino and V is vertical.
      T . V
      This is one L-tromino covering (0,0),(1,0),(0,1). Then (1,1), (0,2), (1,2) remain.
      (0,0) (0,1) (0,2)
      (1,0) (1,1) (1,2)

      A) Top-left L-tromino:
         X X .
         X . .
         Remaining:  . . X
                     . X X
         This can be filled by one L-tromino. (1 way)

      B) Bottom-left L-tromino:
         X . .
         X X .
         Remaining:  . X X
                     . . X
         This can be filled by one L-tromino. (1 way)
    These are the two ways using two L-trominoes.
    So, dp[3] = (2*dp[2]) + dp[0] = 2*2 + 1 = 5. This matches.

The solution uses this recurrence with modulo arithmetic.
MOD = 10^9 + 7
*/
public class Solution {
    public int numTilings(int n) {
        final int MOD = (int) 1e9 + 7;
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i-1] + dp[i-3]) % MOD;
        }
        return (int) dp[n];
    }
}