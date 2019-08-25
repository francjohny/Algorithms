package SmallestPostiveInteger;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Find the smallest positive integer that does not occur in a given sequence.
 *
 * Input: [1, 3, 6, 4, 1, 2]
 * Output: 5
 *
 * Input: [-1, -2, -2]
 * Output: 1
 *
 */
class Naive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(new Naive().solution(arr));
    }

    public int solution(int[] A) {
        Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());
        int count = 1;
        for (int ignored : set) {
            if (!set.contains(count)) {
                return count;
            } else {
                count++;
            }
        }
        return count;
    }
}
