/**
 * Problem Link - https://www.hackerrank.com/challenges/counting-valleys
 */

import java.util.*;

public class Solution {

    private static int countingValleys(String s) {
        int level = 0, countValleys = 0;

        for(char step: s.toCharArray()) {
            if (step == 'U') {
                ++level;
                if (level == 0) countValleys++;
            }

            if (step == 'D') --level;
        }

        return countValleys;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(s);

        System.out.println(result);

        scanner.close();
    }
}
