/**
 * Problem Link - https://www.hackerrank.com/challenges/angry-professor
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < T; i++) {
            String[] nk = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int countTimelyArrival = 0;
            for (int j = 0; j < n; j++) {
                int aItem = Integer.parseInt(aItems[j]);
                if (aItem <= 0) {
                    ++countTimelyArrival;
                    if (countTimelyArrival == k) {
                        break;
                    }
                }
            }
            System.out.println(countTimelyArrival < k ? "YES" : "NO");
        }
        scanner.close();
    }
}
