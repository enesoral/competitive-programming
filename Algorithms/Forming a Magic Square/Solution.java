/**
 * Problem Link - https://www.hackerrank.com/challenges/magic-square-forming
 */

import java.util.*;

public class Solution {

    static int formingMagicSquare(int[][] givenSquare) {
        // There are eight possibilities building a 3x3 magic square -> http://www.mathematische-basteleien.de/magsquare.htm
        int[][][] permutations = {  {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                                    {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                                    {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                                    {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                                    {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                                    {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                                    {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                                    {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}} };

        int minCost = Integer.MAX_VALUE;

        for (int perm = 0; perm < permutations.length; perm++) {
            int cost = 0;

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    cost += Math.abs(givenSquare[i][j] - permutations[perm][i][j]);

            if (cost < minCost)
                minCost = cost;
        }

        return minCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] givenSquare = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] rowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(rowItems[j]);
                givenSquare[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(givenSquare);

        System.out.println(result);

        scanner.close();
    }
}
