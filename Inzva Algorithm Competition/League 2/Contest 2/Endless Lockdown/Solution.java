/**
 * Problem Link - https://www.hackerrank.com/contests/inzva-algorithm-competition-league-2-contest-2/challenges/endless-lockdown
 *
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long boxes = in.nextLong();
        long days = in.nextLong();
        long a = 0;

        if (days > boxes) {
            a = days / boxes;
            if (days % boxes > 0) ++a; 
        } else {
            a = 1;
        }
        System.out.println(a);
    }
}
