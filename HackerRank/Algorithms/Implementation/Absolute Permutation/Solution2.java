/**
 * Problem Link - https://www.hackerrank.com/challenges/absolute-permutation
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        tests:
        while (T-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            Map<Integer, Integer> pos = new HashMap<>();

            for (int i = 1; i <= n; ++i) {
                int ind1 = i - k;
                int ind2 = i + k;

                if (ind1 > 0 && !pos.containsKey(ind1)) {
                    pos.put(ind1, i);
                } else if (ind2 <= n && !pos.containsKey(ind2)) {
                    pos.put(ind2, i);
                } else {
                    System.out.println("-1");
                    continue tests;
                }
            }

            for (int i = 1; i <= n; ++i) {
                System.out.print(pos.get(i) + " ");
            }

            System.out.println();
        }
    }
}
