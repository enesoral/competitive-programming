/**
 * Problem Link - https://www.hackerrank.com/challenges/migratory-birds
 */

import java.util.*;

public class Solution {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        int arrCount = scanner.nextInt();
        int[] migratory = new int[5];

        for (int i = 0; i < arrCount; i++) {
            int val = scanner.nextInt();
            migratory[val - 1]++;
        }

        int max = migratory[0], maxIndex = 0;
        for (int i = 1; i < migratory.length; i++) {
            if (migratory[i] > max) {
                max = migratory[i];
                maxIndex = i;
            }
        }

        System.out.println(maxIndex + 1);

        scanner.close();
    }
}
