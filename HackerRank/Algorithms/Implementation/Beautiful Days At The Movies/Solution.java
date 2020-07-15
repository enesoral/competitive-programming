/**
 * Problem Link - https://www.hackerrank.com/challenges/beautiful-days-at-the-movies
 */

import java.util.*;

public class Solution {

    private static int reverseNumber(int number) {
        int reverseNumber = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            reverseNumber = (reverseNumber * 10) + lastDigit;
            number /= 10;
        }
        return reverseNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] duk = scanner.nextLine().split(" ");
        int d = Integer.parseInt(duk[0]);
        int u = Integer.parseInt(duk[1]);
        int k = Integer.parseInt(duk[2]);

        int countBeautifulDay = 0;
        for (int num = d; num <= u; num++) {
            if (Math.abs(num - reverseNumber(num)) % k == 0)
                ++countBeautifulDay;
        }

        System.out.println(countBeautifulDay);
        scanner.close();
    }
}
