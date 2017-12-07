package IceCreamParlor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Optimised {
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
        HashMap<Integer, Integer> freq = new HashMap<>(size);

        for (Integer flavor : flavors) {
            if (freq.containsKey(flavor))
                freq.put(flavor, freq.get(flavor) + 1);
            else freq.put(flavor, 1);
        }

        for (int i = 0; i < size; i++) {
            int remaining = money - flavors.get(i);
            if (freq.containsKey(remaining) && freq.get(remaining) > 0) {
                freq.put(remaining, freq.get(remaining) - 1);
                int index = getIndex(flavors, remaining, i + 1);
                if (index != -1) {
                    System.out.println((i + 1) + " " + (index + 1));
                    return;
                }
            }
        }
    }

    private static int getIndex(List<Integer> flavors, int remaining, int j) {
        for (int i = j; i < flavors.size(); i++) {
            if (flavors.get(i) == remaining)
                return i;
        }
        return -1;
    }
}
