/**
 * Problem Link - https://www.hackerrank.com/challenges/append-and-delete
 */

import java.util.*;

public class Solution {

    private static boolean canConvert(String s, String t, int k) {
        if (s.length() + t.length() <= k) {
            return true;
        }

        int commonLength = 0;
        for(int i = 0; i < Math.min(s.length(), t.length()); ++i) {
            if (s.charAt(i) == t.charAt(i)) {
                ++commonLength;
            } else {
                break;
            }
        }
        
        int minOperations = s.length() + t.length() - 2 * commonLength;
        if (minOperations <= k && (minOperations % 2 == k % 2)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int k = scanner.nextInt();

        System.out.println(canConvert(s, t, k) ? "Yes" : "No");
        scanner.close();
    }
}
