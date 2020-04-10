/**
 * Problem Link - https://www.hackerrank.com/challenges/the-hurdle-race
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int max = Integer.MIN_VALUE;
        while(n-- > 0) {
            int hurdleHeight = scanner.nextInt();

            if (hurdleHeight > max)
                max = hurdleHeight;
        }

        System.out.println(Math.max(max - k, 0));
        scanner.close();
    }
}
