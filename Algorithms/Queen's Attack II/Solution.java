/**
 * Problem Link - https://www.hackerrank.com/challenges/queens-attack-2
 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int rQueen = scan.nextInt();
        int cQueen = scan.nextInt();

        int rTObstacle = -1;
        int rBObstacle = -1;
        int cRObstacle = -1;
        int cLObstacle = -1;
        int rTRObstacle = -1;
        int rTLObstacle = -1;
        int rBRObstacle = -1;
        int rBLObstacle = -1;

        for (int i = 0; i < k; ++i) {
            int rObstacle = scan.nextInt();
            int cObstacle = scan.nextInt();

            if((rObstacle < rTObstacle || rTObstacle == -1) && (rObstacle > rQueen && cObstacle == cQueen)) {
                rTObstacle = rObstacle;
            }

            else if((rObstacle > rBObstacle) && (rObstacle < rQueen && cObstacle == cQueen)) {
                rBObstacle = rObstacle;
            }

            else if((cObstacle < cRObstacle || cRObstacle == -1) && (cObstacle > cQueen && rObstacle == rQueen)) {
                cRObstacle = cObstacle;
            }

            else if((cObstacle > cLObstacle) && (cObstacle < cQueen && rObstacle == rQueen)) {
                cLObstacle = cObstacle;
            }

            else if((rObstacle < rTRObstacle || rTRObstacle == -1) && (rObstacle - rQueen == cObstacle - cQueen)
                    && (rObstacle > rQueen && cObstacle > cQueen)) {
                rTRObstacle = rObstacle;
            }

            else if((rObstacle < rTLObstacle || rTLObstacle == -1) && (rObstacle - rQueen == cQueen - cObstacle)
                    && (rObstacle > rQueen && cQueen > cObstacle)) {
                rTLObstacle = rObstacle;
            }

            else if((rObstacle > rBRObstacle) && (rQueen - rObstacle == cObstacle - cQueen)
                    && (rQueen > rObstacle && cObstacle > cQueen)) {
                rBRObstacle = rObstacle;
            }

            else if((rObstacle > rBLObstacle) && (rQueen - rObstacle == cQueen - cObstacle)
                    && (rQueen > rObstacle && cQueen > cObstacle)) {
                rBLObstacle = rObstacle;
            }
        }

        int attackableSquares = 0;

        attackableSquares += (rTObstacle != -1) ? (rTObstacle - rQueen - 1) : (n - rQueen);
        attackableSquares += (rBObstacle != -1) ? (rQueen - rBObstacle - 1) : (rQueen - 1);
        attackableSquares += (cRObstacle != -1) ? (cRObstacle - cQueen - 1) : (n - cQueen);
        attackableSquares += (cLObstacle != -1) ? (cQueen - cLObstacle - 1) : (cQueen - 1);
        attackableSquares += (rTRObstacle != - 1) ? (rTRObstacle - rQueen - 1) : Math.min(n - rQueen, n - cQueen);
        attackableSquares += (rTLObstacle != - 1) ? (rTLObstacle - rQueen - 1) : Math.min(n - rQueen, cQueen - 1);
        attackableSquares += (rBRObstacle != - 1) ? (rQueen - rBRObstacle - 1) : Math.min(n - cQueen, rQueen - 1);
        attackableSquares += (rBLObstacle !=  -1) ? (rQueen - rBLObstacle - 1) : Math.min(rQueen - 1, cQueen - 1);

        System.out.println(attackableSquares);
    }
}
