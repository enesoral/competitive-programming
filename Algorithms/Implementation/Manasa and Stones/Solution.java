/**
 * Problem Link - https://www.hackerrank.com/challenges/manasa-and-stones
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T-- > 0) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            if (a == b) {
                System.out.println(a * (n - 1));
                continue;
            }

            if (b < a) {
                int temp = a;
                a = b;
                b = temp;
            }

            int min = a * (n - 1);
            int max = b * (n - 1);

            for (int i = min; i <= max; i += (b - a)) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
