/**
 * Problem Link - https://www.hackerrank.com/challenges/divisible-sum-pairs
 */

import java.util.*;

public class Solution {

    private static int divisibleSumPairs(int k, int[] ar) {
        int count = 0;
        int[] bucket = new int[k];

        for(int val: ar) {
            int mod = val % k;
            count += bucket[(k - mod) % k];
            bucket[mod]++;
        }

        return count;
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = divisibleSumPairs(k, ar);

        System.out.println(result);

        scanner.close();
    }
}
