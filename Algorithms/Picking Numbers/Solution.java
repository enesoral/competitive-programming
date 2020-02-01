/**
 * Problem Link - https://www.hackerrank.com/challenges/picking-numbers
 */

import java.util.*;

public class Solution {

    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        final int LIMIT = 100;
        int[] countNumbers = new int[LIMIT];
        while (n-- > 0) {
            int number = scanner.nextInt();
            countNumbers[number - 1]++;
        }

        int result = Integer.MIN_VALUE;
        for(int i = 0; i < LIMIT - 1; i++) {
            result = Math.max(result, countNumbers[i] + countNumbers[i + 1]);
        }

        System.out.println(result);
        scanner.close();
    }
}
