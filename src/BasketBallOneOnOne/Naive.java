package BasketBallOneOnOne;

import java.util.Scanner;

public class Naive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] record = scanner.next().toCharArray();
        int scoreA = 0, scoreB = 0;
        System.out.println(getScore(record, scoreA, scoreB));
    }

    private static String getScore(char[] record, int scoreA, int scoreB) {
        for (int i = 0; i < record.length; i += 2) {
            if (scoreA == 11) {
                return "A";
            } else if (scoreB == 11) {
                return "B";
            } else {
                char player = record[i];
                int score = record[i + 1] - '0';
                if (player == 'A' && scoreA >= 10 && scoreA + score > scoreB && i == record.length - 2) {
                    return "A";
                } else if (player == 'B' && scoreB >= 10 && scoreB + score > scoreA && i == record.length - 2) {
                    return "B";
                }
                if (player == 'A') {
                    scoreA += score;
                } else if (player == 'B') {
                    scoreB += score;
                }
            }
        }
        return scoreA > scoreB ? "A" : "B";
    }
}
