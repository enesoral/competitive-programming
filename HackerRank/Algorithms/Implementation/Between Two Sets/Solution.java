// PROBLEM LINK: https://www.hackerrank.com/challenges/between-two-sets

import java.util.*;

class Result {

    public static int getTotalX(int[] a, int[] b) {
        int start = a[a.length - 1], stop = b[0];
        int count = 0;

        for (int i = start; i <= stop; i++) {
            boolean isDividing = true;

            for (int x: a) {
                if (i % x != 0) {
                    isDividing = false;
                    break;
                }
            }

            if (isDividing) {
                for(int x: b) {
                    if (x % i != 0) {
                        isDividing = false;
                        break;
                    }
                }
            }

            if (isDividing)
                count++;
        }

        return count;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        int[] brr = new int[m];
        for(int i = 0; i < m; i++)
            brr[i] = scanner.nextInt();

        int total = Result.getTotalX(arr, brr);

        System.out.println(total);
    }
}