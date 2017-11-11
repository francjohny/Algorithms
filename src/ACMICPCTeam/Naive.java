package ACMICPCTeam;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = in.next();
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>(); // map with key: topic count, value: number of teams knowing that many topics
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // count number of topics known by teams ..., (1,2), (1, 3), (1, 4), (2, 3), (2, 4), (3, 4), ...
                int count = checkIfAllOnes(m, strings[i], strings[j]);
                hashMap.put(count, hashMap.getOrDefault(count, 0) + 1);
            }
        }
        Integer max = Collections.max(hashMap.keySet());
        System.out.println(max);
        System.out.println(hashMap.get(max));
    }

    /*Given a team with 2 members with known topics a and b respectively
    * find how many topics both team members know
    * This can be easily obtained by ORing the bits/topics known by each member*/
    private static int checkIfAllOnes(int m, String a, String b) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            if ((Character.getNumericValue(a.charAt(i)) | Character.getNumericValue(b.charAt(i))) == 1)
                count++;
        }
        return count;
    }
}
