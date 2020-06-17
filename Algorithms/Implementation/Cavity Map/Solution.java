/**
 * Problem Link - https://www.hackerrank.com/challenges/cavity-map
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[][] depths = new char[n][n];

        for (int i = 0; i < n; ++i) {
            String grid = in.nextLine();
            for (int j = 0; j < n; ++j) {
                depths[i][j] = grid.charAt(j);
            }
        }

        for (int i = 1; i < n - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                int cell = depths[i][j];
                int adjacent1 = depths[i - 1][j];
                int adjacent2 = depths[i + 1][j];
                int adjacent3 = depths[i][j - 1];
                int adjacent4 = depths[i][j + 1];

                if (cell > adjacent1 && cell > adjacent2 && cell > adjacent3 && cell > adjacent4) {
                    depths[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(depths[i][j]);
            }
            System.out.printf("%n");
        }
    }
}
