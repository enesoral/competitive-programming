/**
 * Problem Link - https://www.hackerrank.com/challenges/chocolate-feast
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        while (T-- > 0) {
            int money = scan.nextInt();
            int cost = scan.nextInt();
            int forFree = scan.nextInt(); // required wrapper for free

            int ate = money / cost;
            int wrapper = money / cost;
            while (wrapper >= forFree) {
                ate += wrapper / forFree;
                wrapper = wrapper / forFree + wrapper % forFree;
            }

            System.out.println(ate);
        }
    }
}
