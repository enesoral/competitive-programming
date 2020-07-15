/**
 * Problem Link - https://www.hackerrank.com/challenges/library-fine
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] d1M1Y1 = scanner.nextLine().split(" ");
        int returnDay = Integer.parseInt(d1M1Y1[0]);
        int returnMonth = Integer.parseInt(d1M1Y1[1]);
        int returnYear = Integer.parseInt(d1M1Y1[2]);
        String[] d2M2Y2 = scanner.nextLine().split(" ");
        int expectedDay = Integer.parseInt(d2M2Y2[0]);
        int expectedMonth = Integer.parseInt(d2M2Y2[1]);
        int expectedYear = Integer.parseInt(d2M2Y2[2]);

        int fine = 0;
        if (returnYear == expectedYear) {
            if (returnMonth > expectedMonth){
                fine = (returnMonth - expectedMonth) * 500;
            } else if (returnMonth == expectedMonth){
                if (returnDay > expectedDay) {
                    fine = (returnDay - expectedDay) * 15;
                }
            }
        } else if (returnYear > expectedYear) {
            fine = 10000;
        }

        System.out.println(fine);
        scanner.close();
    }
}
