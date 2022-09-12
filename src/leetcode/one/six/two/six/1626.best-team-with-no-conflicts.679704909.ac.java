package leetcode.one.six.two.six;

import java.util.Arrays;

class Solution {
    
    // INPUT: scores and ages of players
    // OUTPUT: max score by picking a team of players of different ages such that there is no conflict
    // i.e. no conflict means a younger player has lesser score than an older player
    
    class Player {
        int score;
        int age;
        
        Player(int s, int a) {
            this.score = s;
            this.age = a;
        }
        
        public static int compareThem(Player a, Player b) {
            int ans = Integer.compare(a.age, b.age);
            return ans == 0 ? Integer.compare(a.score, b.score) : ans;
        }
    }
    
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Player[] players = new Player[n];
        for(int i = 0; i < n; i++) {
            players[i] = new Player(scores[i], ages[i]);
        }
        Arrays.sort(players, Player::compareThem);
        // ages: 1 2 3 4 5
        // score[1] < score[2] < score[3] < score[4] < score[5]
        // max score = sum of 1..5
        // score[1] < score[2] < score[4] < score[5]
        // max score = sum of 1..2 + 4..5
        // max score at each index = score so far, score so far + current score
        int[] dp = new int[n]; // max score obtained so far at index
        int result = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = players[i].score;
            for(int j = 0; j < i; j++) {
                if (players[i].score >= players[j].score) {
                    dp[i] = Math.max(dp[i], dp[j] + players[i].score);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
