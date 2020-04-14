/**
 * Problem Link - https://www.hackerrank.com/challenges/beautiful-triplets
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        Map<Integer, Integer> valuesFrequency = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            int val = scan.nextInt();
            if(valuesFrequency.containsKey(val)) {
                valuesFrequency.put(val, valuesFrequency.get(val) + 1);
            } else {
                valuesFrequency.put(val, 1);
            }

        }

        int countBeautifulTriplets = 0;
        for(int val: valuesFrequency.keySet()) {
            if(valuesFrequency.containsKey(val + d) && valuesFrequency.containsKey(val + (2 * d))) {
                countBeautifulTriplets += valuesFrequency.get(val);
            }
        }
        System.out.println(countBeautifulTriplets);
    }
}
