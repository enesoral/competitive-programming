/**
 * Problem Link - https://www.hackerrank.com/challenges/non-divisible-subset
 */

import java.util.*;

public class Solution {

    private static int getNonDivisibleSubsetSize(int k, int[] modulus) {
        int result = 0;
        for(int i = 0; i <= k / 2; ++i) {
            int complement = (k - i) % k;
            if (i == complement && modulus[i] >= 1) {
                result += 1;
            } else {
                result += Math.max(modulus[i], modulus[complement]);
            }
        }
        return result;
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] modulus = new int[k];
        for (int i = 0; i < n; ++i) {
            ++modulus[scanner.nextInt() % k];
        }
        scanner.close();

        int result = getNonDivisibleSubsetSize(k, modulus);
        System.out.println(result);
    }
}
