// PROBLEM LINK: https://www.hackerrank.com/challenges/diagonal-difference

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arraySize = scan.nextInt();

        int rightDiagonal = 0;
        int leftDiagonal = scan.nextInt();

        for (int i = 1; i < (arraySize * arraySize); i++) {
            int value = scan.nextInt();

            if (i % (arraySize - 1) == 0 && i != (arraySize * arraySize) - 1)
                rightDiagonal += value;

            if (i % (arraySize + 1) == 0)
                leftDiagonal += value;
        }

        System.out.println(Math.abs(leftDiagonal - rightDiagonal));
    }
}

