/**
 * Problem Link - https://www.hackerrank.com/challenges/utopian-tree
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int[] wantedPeriods = new int[t];
        for (int i = 0; i < t; i++) {
            wantedPeriods[i] = scanner.nextInt();
        }

        int max = Arrays.stream(wantedPeriods).max().getAsInt();
        int[] calculatedPeriods = new int[max + 1];
        calculatedPeriods[0] = 1;
        for (int i = 1; i <= max; i++) {
            if (i % 2 == 1) {
                calculatedPeriods[i] = calculatedPeriods[i - 1] * 2;
            } else {
                calculatedPeriods[i] = calculatedPeriods[i - 1] + 1;
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println(calculatedPeriods[wantedPeriods[i]]);
        }

        scanner.close();
    }
}
