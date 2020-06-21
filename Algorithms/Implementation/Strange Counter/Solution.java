/**
 * Problem Link - https://www.hackerrank.com/challenges/strange-code
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long time = in.nextLong();

        long totalTime = 0;
        long slot = 3;
        while (time > totalTime) {
            totalTime += slot;
            slot *= 2;
        }

        System.out.println(totalTime - time + 1);
    }
}
