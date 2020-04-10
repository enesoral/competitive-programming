/**
 * Problem Link - https://www.hackerrank.com/challenges/electronics-shop
 */

import java.util.*;

public class Solution {
    private static int getMoneySpent(int[] keyboards, Integer[] drives, int b) {

        int max = -1;
        for (int i = 0, j = 0; i < drives.length; i++) {
            for ( ; j < keyboards.length; j++) {
                 if (drives[i] + keyboards[j] > b) break;

                 if (drives[i] + keyboards[j] > max)
                     max = drives[i] + keyboards[j];

                 if (max == b)
                     return max;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bnm = scanner.nextLine().split(" ");
        int b = Integer.parseInt(bnm[0]);
        int n = Integer.parseInt(bnm[1]);
        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];
        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            keyboards[keyboardsItr] = scanner.nextInt();
        }

        Integer[] drives = new Integer[m];
        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            drives[drivesItr] = scanner.nextInt();
        }

        Arrays.sort(keyboards);
        Arrays.sort(drives, Collections.reverseOrder());

        int moneySpent = getMoneySpent(keyboards, drives, b);

        System.out.println(moneySpent);

        scanner.close();
    }
}
