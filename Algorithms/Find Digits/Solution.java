/**
 * Problem Link - https://www.hackerrank.com/challenges/find-digits
 */

import java.util.*;

public class Solution {

    private static int findDigits(int num) {
        int count = 0, tempNum = num;
        while (tempNum != 0) {
            int rem = tempNum % 10;
            if (rem != 0 && num % rem == 0) {
                ++count;
            }
            tempNum /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            int result = findDigits(n);
            System.out.println(result);
        }
        scanner.close();
    }
}
