/**
 * Problem Link - https://www.hackerrank.com/challenges/cats-and-a-mouse
 */

import java.util.*;

public class Solution {

    private static String catAndMouse(int x, int y, int z) {

        if (Math.abs(z - x) < Math.abs(z - y)) {
            return "Cat A";
        } else if (Math.abs(z - x) > Math.abs(z - y)) {
            return "Cat B";
        } else {
            return "Mouse C";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalQuery = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < totalQuery; i++) {
            String[] xyz = scanner.nextLine().split(" ");
            int x = Integer.parseInt(xyz[0]);
            int y = Integer.parseInt(xyz[1]);
            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            System.out.println(result);
        }

        scanner.close();
    }
}
