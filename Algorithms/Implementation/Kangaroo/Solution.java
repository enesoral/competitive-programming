// PROBLEM LINK: https://www.hackerrank.com/challenges/kangaroo

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int v2 = scanner.nextInt();

        if(canLandOnSameLocation(x1, v1, x2, v2))
            System.out.println("YES");
        else
            System.out.println("NO");

        scanner.close();
    }

    private static boolean canLandOnSameLocation(int x1, int v1, int x2, int v2) {
        if (v1 > v2 && (x2 - x1) % (v1 - v2) == 0)
            return true;

        return false;
    }
}