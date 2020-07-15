/**
 * Problem Link - https://www.hackerrank.com/challenges/the-grid-search
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        tests:
        while (T-- > 0) {
            int R = in.nextInt();
            int C = in.nextInt();
            in.nextLine();
            int[][] G = new int[R][C];

            for (int i = 0; i < R; ++i) {
                String row = in.nextLine();
                for (int j = 0; j < C; ++j) {
                    G[i][j] = Character.getNumericValue(row.charAt(j));
                }
            }

            int r = in.nextInt();
            int c = in.nextInt();
            in.nextLine();
            int[][] P = new int[r][c];

            for (int i = 0; i < r; ++i) {
                String row = in.nextLine();
                for (int j = 0; j < c; ++j) {
                    P[i][j] = Character.getNumericValue(row.charAt(j));
                }
            }

            for (int i = 0; i < R; ++i) {
                for (int j = 0; j < C; ++j) {
                    if (G[i][j] == P[0][0] && j <= C - c) {
                        if (isMatch(i, j, G, P)) {
                            System.out.println("YES");
                            continue tests;
                        }
                    }
                }
            }
            System.out.println("NO");
        }
    }

    private static boolean isMatch(int i, int j, int[][] G, int[][] P) {
        int colG = j;

        for (int r = 0; r < P.length; ++r, ++i) {
            for (int c = 0; c < P[0].length; ++c, ++j) {
                if (G[i][j] != P[r][c]) {
                    return false;
                }
            }
            j = colG;
        }
        return true;
    }
}
