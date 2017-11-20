package ACMICPCTeam;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/*
 * You are given a list of  people who are attending ACM-ICPC World Finals.
 * Each of them are either well versed in a topic or they are not.
 * Find out the maximum number of topics a 2-person team can know.
 * And also find out how many teams can know that maximum number of topics.
 * Note Suppose a, b, and c are three different people, then (a,b) and (b,c) are counted as two different teams.
 *
 * Input: N M
 * N - number of people
 * M - number of topics
 * Each line contains a binary string of length M.
 * If the ith line's jth character is 1, then the ith person knows the jth topic; otherwise, he doesn't know the topic.
 *
 * Example:
 * Input: 4 5
 * 10101
 * 11100
 * 11010
 * 00101
 *
 * Output:
 * 5
 * 2
 */
public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] players = new String[n];
        for (int i = 0; i < n; i++) {
            players[i] = in.next();
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>(); // map with key: topic count, value: number of teams knowing that many topics
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // count number of topics known by teams ..., (1,2), (1, 3), (1, 4), (2, 3), (2, 4), (3, 4), ...
                int count = countTopics(m, players[i], players[j]);
                hashMap.put(count, hashMap.getOrDefault(count, 0) + 1);
            }
        }
        Integer max = Collections.max(hashMap.keySet());
        System.out.println(max);
        System.out.println(hashMap.get(max));
    }

    /*
     * Given a team with 2 members with known topics a and b respectively
     * Find how many topics both team members know
     * This can be easily obtained by ORing the bits/topics known by each member
     */
    private static int countTopics(int m, String playerA, String playerB) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            if ((Character.getNumericValue(playerA.charAt(i)) | Character.getNumericValue(playerB.charAt(i))) == 1)
                count++;
        }
        return count;
    }
}
