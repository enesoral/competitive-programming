/**
 * Problem Link - https://www.hackerrank.com/challenges/fair-rations
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int breadOfPerson = 0;
        int givenBread = 0;

        for (int i = 0; i < n; ++i) {
            breadOfPerson += in.nextInt();

            if (breadOfPerson % 2 == 1) {
                breadOfPerson = 1;
                givenBread += 2;
            }
        }

        System.out.println(breadOfPerson % 2 == 0 ? givenBread : "NO");
    }
}
