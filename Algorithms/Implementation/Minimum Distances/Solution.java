/**
 * Problem Link - https://www.hackerrank.com/challenges/minimum-distances
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Map<Integer, Integer> distances = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int val = scan.nextInt();
            if (distances.containsKey(val)) {
                if (i - distances.get(val) < minDistance) {
                    minDistance = i - distances.get(val);
                }
            }
            distances.put(val, i);
        }
        System.out.println(minDistance != Integer.MAX_VALUE ? minDistance : -1);
    }
}
