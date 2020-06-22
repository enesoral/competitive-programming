/**
 * Problem Link - https://www.hackerrank.com/challenges/3d-surface-area
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        byte H = in.nextByte();
        byte W = in.nextByte();
        byte[][] A = new byte[H][W];

        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < W; ++j) {
                A[i][j] = in.nextByte();
            }
        }

        int surfaceArea = 0;

        surfaceArea += H * W * 2;   // floor, upper

        for (int i = 0; i < H; ++i) { // front, back
            surfaceArea += A[i][0];
            surfaceArea += A[i][W - 1];
        }

        for (int i = 0; i < W; ++i) {   // left, right
            surfaceArea += A[0][i];
            surfaceArea += A[H - 1][i];
        }

        for (int r = 0; r < H; ++r) {   // other exposed area
            for (int c = 0; c < W; ++c) {

                int[] x = {r - 1, r + 1, r, r};
                int[] y = {c, c, c - 1, c + 1};

                for (int i = 0; i < x.length; ++i) {
                    if (x[i] >= 0 && x[i] < H && y[i] >= 0 && y[i] < W) {
                        surfaceArea += Math.max(0, A[r][c] - A[x[i]][y[i]]);
                    }
                }

                /*
                int i1 = i - 1;
                int i2 = i + 1;
                int j1 = j - 1;
                int j2 = j + 1;

                if (i1 >= 0 && i1 < H && A[i][j] - A[i1][j] > 0) {
                    surfaceArea += A[i][j] - A[i1][j];
                }
                if (i2 >= 0 && i2 < H && A[i][j] - A[i2][j] > 0) {
                    surfaceArea += A[i][j] - A[i2][j] ;
                }
                if (j1 >= 0 && j1 < W && A[i][j] - A[i][j1] > 0) {
                    surfaceArea += A[i][j] - A[i][j1];
                }
                if (j2 >= 0 && j2 < W && A[i][j] - A[i][j2] > 0) {
                    surfaceArea += A[i][j] - A[i][j2];
                }
                 */
            }
        }

        System.out.println(surfaceArea);
    }
}
