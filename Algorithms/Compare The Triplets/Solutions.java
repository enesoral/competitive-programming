// PROBLEM LINK: https://www.hackerrank.com/challenges/compare-the-triplets/ 

import java.util.*;

public class Solution {

    static int[] compareTriplets(int[] aliceScores, int[] bobScores) {
        int aTotalScore = 0, bTotalScore = 0;

        for (int i = 0; i < 3; i++) {
            int aScore = aliceScores[i], bScore = bobScores[i];
            if (aScore > bScore) {
                aTotalScore++;
            } else if (bScore > aScore) {
                bTotalScore++;
            }
        }

        int[] scores = {aTotalScore, bTotalScore};

        return scores;
    }

    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        int[] aliceScores = new int[3];
        int[] bobScores = new int[3];

        for(int i = 0; i < 3; i++)
            aliceScores[i] = scan.nextInt();

        for(int i = 0; i < 3; i++)
            bobScores[i] = scan.nextInt();

        int[] scores = compareTriplets(aliceScores, bobScores);
        System.out.println(scores[0] + " " + scores[1]);
    }
}