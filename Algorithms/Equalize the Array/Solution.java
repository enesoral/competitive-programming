/**
 * Problem Link - https://www.hackerrank.com/challenges/equality-in-a-array
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> numToCount = new HashMap<>();
        int highestFreq = 0;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (!numToCount.containsKey(num)) {
                numToCount.put(num, 0);
            }
            numToCount.put(num, numToCount.get(num) + 1);
            highestFreq = (numToCount.get(num) > highestFreq) ? numToCount.get(num) : highestFreq;
        }
        scanner.close();
        System.out.println(n - highestFreq);
    }
}
