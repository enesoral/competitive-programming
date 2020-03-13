/**
 * Problem Link - https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        scanner.close();

        int energy = 100, index = 0;
        do {
            index = (index + k) % n;
            if (c[index] == 1) {
                energy -= 2;
            }
            --energy;
        } while(index != 0);
        System.out.println(energy);
    }
}
