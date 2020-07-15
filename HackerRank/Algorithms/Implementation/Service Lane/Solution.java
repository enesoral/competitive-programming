/**
 * Problem Link - https://www.hackerrank.com/challenges/service-lane
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int T = scan.nextInt();
        byte[] widths = new byte[n];
        for (int i = 0; i < n; ++i) {
            widths[i] = scan.nextByte();
        }

        while (T-- > 0) {
            int i = scan.nextInt();
            int j = scan.nextInt();

            byte min = 3;
            for (int k = i; k <= j; ++k) {
                min = (byte) Math.min(widths[k], min);
                if (min == 1) {
                    break;
                }
            }
            System.out.println(min);
        }
    }
}
