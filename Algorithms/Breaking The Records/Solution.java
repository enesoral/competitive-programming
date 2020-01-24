// PROBLEM LINK: https://www.hackerrank.com/challenges/breaking-best-and-worst-records

import java.util.*;

public class Solution {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        System.out.println(result[0] + " " + result[1]);

        scanner.close();
    }

    private static int[] breakingRecords(int[] scores) {
        int countBest = 0, countWorst = 0;
        int minScore = scores[0], maxScore = scores[0];

        for(int i = 1; i < scores.length; i++) {
            if (scores[i] < minScore) {
                minScore  = scores[i];
                countWorst++;
            }

            if (scores[i] > maxScore) {
                maxScore = scores[i];
                countBest++;
            }
        }

        int[] result = {countBest, countWorst};
        return result;
    }
}