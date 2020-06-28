/**
 * Problem Link - https://www.hackerrank.com/challenges/two-pluses
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Plus {
        public int x;
        public int y;
        public int len;

        public Plus(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();

        char[][] cells = new char[r][c];
        for (int i = 0; i < r; ++i) {
            String row = in.next();
            for (int j = 0; j < c; ++j) {
                cells[i][j] = row.charAt(j);
            }
        }

        List<Plus> pluses = new ArrayList<>();
        int haveLength0 = 0;
        for (int i = 1; i < r - 1; ++i) {
            for (int j = 1; j < c - 1; ++j) {
                if (cells[i][j] == 'G') {

                    int x = 1;
                    while (i - x >= 0 && i + x < r && j - x >= 0 && j + x < c) {
                        if (cells[i + x][j] == 'B' ||
                                cells[i - x][j] == 'B' ||
                                cells[i][j + x] == 'B' ||
                                cells[i][j - x] == 'B') {
                            break;
                        }
                        ++x;
                    }

                    if (x == 1 && haveLength0 != 2) {
                        pluses.add(new Plus(i, j, 0));
                        ++haveLength0;
                        continue;
                    }

                    for (int k = 1; k <= x - 1; ++k) {
                        pluses.add(new Plus(i, j, k));
                    }
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < pluses.size() - 1; ++i) {
            Plus plus1 = pluses.get(i);
            int[][] plus1Matrix = getPlusMatrix(plus1 ,r, c);
            for (int j = i + 1; j < pluses.size(); ++j) {
                Plus plus2 = pluses.get(j);
                if (!isOverlaps(plus1Matrix, plus2)) {
                    int area1 = plus1.len * 4 + 1;
                    int area2 = plus2.len * 4 + 1;
                    if (area1 * area2 > maxArea) {
                        maxArea = area1 * area2;
                    }
                }
            }
        }
        System.out.println(maxArea != 0 ? maxArea : (pluses.size() != 0 ? 1 : 0));
    }

    private static int[][] getPlusMatrix(Plus plus, int r, int c) {
        int[][] plusDraw = new int[r][c];
        plusDraw[plus.x][plus.y] = 1;
        for (int i = 1; i <= plus.len; ++i) {
            plusDraw[plus.x + i][plus.y] = 1;
            plusDraw[plus.x - i][plus.y] = 1;
            plusDraw[plus.x][plus.y + i] = 1;
            plusDraw[plus.x][plus.y - i] = 1;
        }
        return plusDraw;
    }

    private static boolean isOverlaps(int[][] plus1Matrix, Plus plus2) {
        for (int i = 1; i <= plus2.len; ++i) {
            if (plus1Matrix[plus2.x + i][plus2.y] == 1 ||
                    plus1Matrix[plus2.x - i][plus2.y] == 1 ||
                    plus1Matrix[plus2.x][plus2.y + i] == 1 ||
                    plus1Matrix[plus2.x][plus2.y - i] == 1) {
                return true;
            }
        }
        return false;
    }
}
