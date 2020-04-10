/**
 * Problem Link - https://www.hackerrank.com/challenges/permutation-equation
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> sequence = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            sequence.put(scanner.nextInt(), i + 1);
        }

        for (int x = 1; x <= n; x++) {
            int index = sequence.get(x);
            System.out.println(sequence.get(index));
        }
        scanner.close();
    }
}
