/**
 * Problem Link - https://www.hackerrank.com/challenges/save-the-prisoner
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] psb = scanner.nextLine().split(" ");
            long totalPrisoners = Integer.parseInt(psb[0]);
            long totalSweets = Integer.parseInt(psb[1]);
            long beginChair = Integer.parseInt(psb[2]);

            if ((beginChair - 1 + totalSweets) % totalPrisoners != 0)
                System.out.println((beginChair - 1 + totalSweets) % totalPrisoners);
            else
                System.out.println(totalPrisoners);
        }
        scanner.close();
    }
}
