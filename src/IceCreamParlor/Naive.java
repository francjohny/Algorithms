package IceCreamParlor;

import java.util.*;

/*
 * Each time Sunny and Johnny take a trip to the Ice Cream Parlor, they pool together m dollars for ice cream.
 * On any given day, the parlor offers a line of n flavors.
 * Each flavor, i, is numbered sequentially with a unique ID number from 1 to n and has a cost, ci, associated with it.
 * Given the value of and the cost of each flavor for trips to the Ice Cream Parlor,
 * help Sunny and Johnny choose two flavors such that they spend their entire pool of money (m) during each visit.
 * For each trip to the parlor,
 * print the ID numbers for the two types of ice cream that Sunny and Johnny purchase as two space-separated integers on a new line.
 * You must print the smaller ID first and the larger ID second.
 *
 * Input:
 * 2
 * 4
 * 5
 * 1 4 5 3 2
 * 4
 * 4
 * 2 2 4 3
 *
 * Output:
 * 1 4
 * 1 2
 */
public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int money = in.nextInt();
            int n = in.nextInt();
            List<Integer> flavors = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                flavors.add(in.nextInt());
            }
            getFlavorsToPurchase(money, flavors);
        }
    }

    private static void getFlavorsToPurchase(int money, List<Integer> flavors) {
        int size = flavors.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (flavors.get(i) + flavors.get(j) == money) {
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
    }
}
