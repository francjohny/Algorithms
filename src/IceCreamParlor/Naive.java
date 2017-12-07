package IceCreamParlor;

import java.util.*;

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
