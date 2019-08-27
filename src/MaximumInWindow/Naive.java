package MaximumInWindow;

import java.util.Arrays;
import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int numbers[] = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i + 1 < numbers.length; i++) {
            if (numbers[i] > numbers[i + 1]) {
                System.out.printf("%d ", numbers[i]);
            } else if (numbers[i + 1] > numbers[i]) {
                System.out.printf("%d ", numbers[i + 1]);
            }
        }
        System.out.println();
    }
}
