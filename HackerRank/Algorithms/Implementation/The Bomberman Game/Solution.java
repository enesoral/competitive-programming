/**
 * Problem Link - https://www.hackerrank.com/challenges/bomber-man
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int R = in.nextInt();
        int C = in.nextInt();
        int N = in.nextInt();

        char[][] first = new char[R + 2][C + 2];

        for (int i = 1; i <= R; i++) {
            String row = in.next();

            for (int j = 1; j <= C; j++)
                first[i][j] = row.charAt(j - 1);
        }

        if (N == 1) {
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++)
                    System.out.print(first[i][j]);
                System.out.println();
            }
            return;
        } else if (N % 2 == 0) {
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++)
                    System.out.print('O');
                System.out.println();
            }
            return;
        }

        int[][] third = new int[R + 2][C + 2];
        for (int i = 1; i <= R; ++i) {
            for (int j = 1; j <= C; ++j)
                if (first[i][j] == 'O')
                    third[i][j] = third[i + 1][j] = third[i][j + 1] = third[i - 1][j] = third[i][j - 1] = 1;
        }


        if (N % 4 == 3) {   // 3 7 11..
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (third[i][j] == 1)
                        System.out.print('.');
                    else
                        System.out.print('O');
                }
                System.out.println();
            }
            return;
        }

        int[][] fifth = new int[R + 2][C + 2];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++)
                if (third[i][j] == 0)
                    fifth[i][j] = fifth[i + 1][j] = fifth[i][j + 1] = fifth[i - 1][j] = fifth[i][j - 1] = 1;
        }

        if (N % 4 == 1) {   // 5 9 13..
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (fifth[i][j] == 1)
                        System.out.print('.');
                    else
                        System.out.print('O');
                }
                System.out.println();
            }
        }
    }
}
