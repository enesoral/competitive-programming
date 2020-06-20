/**
 * Problem Link - https://www.hackerrank.com/challenges/happy-ladybugs
 *
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();

        tests:
        while (g-- > 0) {
            int length = in.nextInt();
            String board = in.next();

            if (board.contains("_")) {
                Map<Character, Integer> freq = new HashMap<>();

                for (int i = 0; i < length; ++i) {
                    char keyC = board.charAt(i);
                    if (freq.containsKey(keyC)) {
                        freq.put(keyC, freq.get(keyC) + 1);
                    } else {
                        freq.put(keyC, 1);
                    }
                }

                freq.remove('_');
                for (char key : freq.keySet()) {
                    if (freq.get(key) == 1) {
                        System.out.println("NO");
                        continue tests;
                    }
                }
            } else {
                if (length == 1) {
                    System.out.println("NO");
                    continue;
                }

                for (int i = 1; i < length - 1; ++i) {
                    char prev = board.charAt(i - 1);
                    char curr = board.charAt(i);
                    char next = board.charAt(i + 1);

                    if (prev != curr && next != curr) {
                        System.out.println("NO");
                        continue tests;
                    }
                }
                char first = board.charAt(0);
                char firstAdjacent = board.charAt(1);
                char last = board.charAt(length - 1);
                char lastAdjacent = board.charAt(length - 2);

                if (first != firstAdjacent || last != lastAdjacent) {
                    System.out.println("NO");
                    continue;
                }
            }
            System.out.println("YES");
        }
    }
}
