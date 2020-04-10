/**
 * Problem Link - https://www.hackerrank.com/challenges/organizing-containers-of-balls
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        for (int q_i = 0; q_i < q; ++q_i) {
            int n = scan.nextInt();
            int[][] M = new int[n][n];

            for (int M_j = 0; M_j < n; ++M_j) {
                for (int M_k = 0; M_k < n; ++M_k) {
                    M[M_j][M_k] = scan.nextInt();
                }
            }

            List<Integer> ballQuantities = new ArrayList<>(n);
            List<Integer> boxCapacities = new ArrayList<>(n);

            for (int i = 0; i < n; ++i) {
                int ballQuantity = 0;
                int boxCapacity = 0;
                for (int j = 0; j < n; ++j) {
                    ballQuantity += M[i][j];
                    boxCapacity += M[j][i];
                }
                ballQuantities.add(ballQuantity);
                boxCapacities.add(boxCapacity);
            }

            boxCapacities.removeAll(ballQuantities);

            if (boxCapacities.isEmpty()) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}
