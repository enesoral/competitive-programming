/**
 * Problem Link - https://www.hackerrank.com/challenges/repeated-string
 */

import java.util.*;

public class Solution {

    private static int getACount(String s, long length) {
        int countA = 0;
        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == 'a')
                ++countA;
        }
        return countA;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        long n = scanner.nextLong();

        int countA = getACount(s, s.length());
        long result = 0;
        long completeRepeating = n / s.length();
        result += completeRepeating * countA;
        long remainStringLength = n % s.length();
        result += getACount(s, remainStringLength);

        System.out.println(result);
        scanner.close();
    }
}
