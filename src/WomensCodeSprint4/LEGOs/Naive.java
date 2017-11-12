package WomensCodeSprint4.LEGOs;

import java.util.Scanner;


/* Sarah has four different kinds of LEGO pieces of different counts.
 * She gives two types of LEGO to her friend and keeps the other two.
 * She is putting two pieces together by picking one from each of the two types that she has left.
 * More specifically, the counts for each of the LEGO pieces are a, b, c and d respectively.
 * The two types that Sarah gave her friend had p and q pieces, while the types that she kept have r and s pieces, respectively.
 * Find which would represent the number of two-piece LEGO combinations that Sarah can make.
 *
 * Input:
 * 2
 * 20 10 40 30
 * 10 30
 * 5 5 10 10
 * 5 10
 *
 *
 * Constrains:
 * 1 <= t <= 40
 * 1 <= a,b,c,d,p,q <= 200
 * **The input is guaranteed to be valid. So in particular, p and q will appear somewhere in [a,b,c,d].**
 *
 * Output:
 * 800
 * 50
 */
public class Naive {

    static int productOfPages(int a, int b, int c, int d, int p, int q) {
        return a * b * c * d / (p * q);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            int answer = productOfPages(a, b, c, d, p, q);
            System.out.println(answer);
        }
        in.close();
    }
}
