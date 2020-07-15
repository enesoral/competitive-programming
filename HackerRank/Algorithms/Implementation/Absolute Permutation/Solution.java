/**
 * Problem Link - https://www.hackerrank.com/challenges/absolute-permutation
 */

import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
 
        tests:
        while (T-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int temp = k;
 
            if (k == 0) {
                for (int i = 1; i <= n; ++i) {
                    System.out.print(i + " ");
                }
            } else if (n % (k * 2) != 0) {
                System.out.print("-1");
            } else {
                for (int i = 1; i <= n; ++i) {
                    System.out.print(i + temp + " ");
                    if (i % k == 0) {
                        temp *= -1;
                    }
                }
            }
            System.out.println();
        }
    }
}
