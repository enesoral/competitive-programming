/**
 * Problem Link - https://www.hackerrank.com/challenges/designer-pdf-viewer
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] heights = new int[26];
        for (int i = 0; i < 26; i++) {
            heights[i] = scanner.nextInt();
        }

        String word = scanner.next();
        int maxHeight = -1;
        for (int i = 0; i < word.length(); i++) {
            maxHeight = Math.max(heights[word.charAt(i) - 97], maxHeight);
        }
        System.out.println(maxHeight * word.length());

        scanner.close();
    }
}
