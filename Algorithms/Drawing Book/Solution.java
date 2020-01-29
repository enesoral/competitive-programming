/**
 * Problem Link - https://www.hackerrank.com/challenges/drawing-book
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();

        int countTurnsFromFront = p / 2;
        int countTurnsFromBack = n / 2 - countTurnsFromFront;

        System.out.println(Math.min(countTurnsFromFront, countTurnsFromBack));

        scanner.close();
    }
}
