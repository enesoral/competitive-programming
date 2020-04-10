/**
 * Problem Link - https://www.hackerrank.com/challenges/jumping-on-the-clouds
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        scanner.close();

        int minOp = 0;
        for(int i = 0; i < c.length - 1; ) {
            if (i + 2 < c.length && c[i + 2] != 1) {
                i += 2;
            } else {
                ++i;
            }
            ++minOp;
        }
        System.out.println(minOp);
    }
}
