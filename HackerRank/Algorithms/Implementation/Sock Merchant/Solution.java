/**
 * Problem Link - https://www.hackerrank.com/challenges/sock-merchant
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Set<Integer> set = new HashSet<>();
        int pairs = 0;

        for (int i = 0; i < n; i++) {
            int sock = scanner.nextInt();

            if (set.contains(sock)) {
                set.remove(sock);
                pairs++;
            } else {
                set.add(sock);
            }
        }

        System.out.println(pairs);

        scanner.close();
    }
}
