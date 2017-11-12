package ServiceLane;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Calvin is driving his favorite vehicle on the 101 freeway.
 * He notices that the check engine light of his vehicle is on, and he wants to service it immediately to avoid any risks.
 * Luckily, a service lane runs parallel to the highway.
 * The length of the service lane is N units.
 * The service lane consists of N segments of equal length and different width.
 * Calvin can enter to and exit from any segment.
 * Let's call the entry segment as index i and the exit segment as index j.
 * Assume that the exit segment lies after the entry segment (i < j) and 0 <= i.
 * Calvin has to pass through all segments from index i to index j(both inclusive).
 *
 * Calvin has three types of vehicles - bike, car, and truck - represented by 1, 2 and 3, respectively.
 * These numbers also denote the width of the vehicle.
 *
 * You are given an array width of length N, where N represents the width of the th segment of the service lane.
 * It is guaranteed that while servicing he can pass through at most 1000 segments, including the entry and exit segments.
 *
 * If width[k] = 1, only the bike can pass through the kth segment.
 * If width[k] = 2, the bike and the car can pass through the kth segment.
 * If width[k] = 3, all three vehicles can pass through the kth segment.
 *
 * Given the entry and exit point of Calvin's vehicle in the service lane,
 * output the type of the largest vehicle which can pass through the service lane (including the entry and exit segments).
 *
 * Input: 8 5
 * 2 3 1 2 3 2 3 3
 * 0 3
 * 4 6
 * 6 7
 * 3 5
 * 0 7
 *
 * Output:
 * 1
 * 2
 * 3
 * 2
 * 1
 */
public class Naive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int width[] = new int[n];
        for (int i = 0; i < n; i++) {
            width[i] = in.nextInt();
        }
        while (t-- > 0) {
            System.out.println(Arrays.stream(Arrays.copyOfRange(width, in.nextInt(), in.nextInt() + 1)).min().getAsInt());
        }
    }
}
