/**
 * Problem Link - https://www.hackerrank.com/challenges/strange-advertising
 */

import java.util.*;

public class Solution {

    private static int viralAdvertising(int n) {
        int todayLikes = 2, countLike = 2;
        for (int i = 2; i <= n; i++) {
            todayLikes = (todayLikes * 3) / 2;
            countLike += todayLikes;
        }
        return countLike;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = viralAdvertising(n);
        System.out.println(result);
        scanner.close();
    }
}
