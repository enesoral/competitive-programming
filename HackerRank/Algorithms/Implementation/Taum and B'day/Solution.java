/**
 * Problem Link - https://www.hackerrank.com/challenges/taum-and-bday
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-- > 0) {
            long totalB = scan.nextInt();
            long totalW = scan.nextInt();
            long bPrice = scan.nextInt();
            long wPrice = scan.nextInt();
            long conversionPrice = scan.nextInt();

            long minBlackPrice = Math.min(bPrice, wPrice + conversionPrice);
            long minWhitePrice = Math.min(wPrice, bPrice + conversionPrice);

            System.out.println(totalB * minBlackPrice + minWhitePrice * totalW);
        }
    }
}
