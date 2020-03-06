/**
 * Problem Link - https://www.hackerrank.com/challenges/cut-the-sticks
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> lengthToCount = new TreeMap<>();

        for (int i = 0; i < n; ++i) {
            int length = scanner.nextInt();
            if (lengthToCount.containsKey(length)) {
                lengthToCount.put(length, lengthToCount.get(length) + 1);
            } else {
                lengthToCount.put(length, 1);
            }
        }

        int cut = n;
        for(int count : lengthToCount.values()) {
            System.out.println(cut);
            cut -= count;
        }
        scanner.close();
    }
}
