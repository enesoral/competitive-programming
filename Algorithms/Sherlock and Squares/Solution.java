/**
 * Problem Link - https://www.hackerrank.com/challenges/sherlock-and-squares
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            System.out.println((int)(Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a))) + 1);
        }
        scanner.close();
    }
}
