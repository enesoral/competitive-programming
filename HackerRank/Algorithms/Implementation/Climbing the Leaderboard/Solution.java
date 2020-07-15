/**
 * Problem Link - https://www.hackerrank.com/challenges/climbing-the-leaderboard
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int scoresCount = scanner.nextInt();
        int[] scores = new int[scoresCount];
        int lastScore = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < scoresCount; i++) {
            int newScore = scanner.nextInt();
            if (newScore != lastScore) {
                scores[index] = newScore;
                index++;
            }
            lastScore = newScore;
        }

        int aliceCount = scanner.nextInt();
        int[] aliceScores = new int[aliceCount];
        for (int i = 0; i < aliceCount; i++)
            aliceScores[i] = scanner.nextInt();

        int scoreIndex = index - 1;
        for (int aliceScore : aliceScores) {
            while (scoreIndex >= 0) {

                if (aliceScore < scores[scoreIndex]) {
                    System.out.println(scoreIndex + 2);
                    break;
                }
                if (scoreIndex == 0) {
                    System.out.println("1");
                    break;
                }
                
                --scoreIndex;
            }
        }
        scanner.close();
    }
}
