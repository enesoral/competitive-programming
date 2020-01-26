/**
 * Problem Link - https://www.hackerrank.com/challenges/day-of-the-programmer
 */

import java.util.Scanner;

public class Solution {

    private static String dayOfProgrammer(int year) {
        int day = 243;

        if (year >= 1700 && year <= 1917) {
            if (year % 4 == 0) day = 244;
        } else if (year >= 1919 && year <= 2700) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) day = 244;
        } else if (year == 1918) {
            day = 230;
        }

        int rem = 256 - day;

        return  rem + ".09." + year;
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        int year = scanner.nextInt();
        String result = dayOfProgrammer(year);
        System.out.println(result);

        scanner.close();
    }
}
