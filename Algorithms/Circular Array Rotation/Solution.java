/**
 * Problem Link - https://www.hackerrank.com/challenges/circular-array-rotation
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nrq = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nrq[0]);
        int rotationCount = Integer.parseInt(nrq[1]) % n;
        int queryCount = Integer.parseInt(nrq[2]);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < queryCount; i++) {
            int query = scanner.nextInt();
            if (query - rotationCount >= 0) {
                System.out.println(a[query - rotationCount]);
            } else {
                System.out.println(a[query - rotationCount + n]);
            }
        }
        scanner.close();
    }
}
