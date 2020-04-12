/**
 * Problem Link - https://www.hackerrank.com/challenges/kaprekar-numbers
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int p = scan.nextInt();
        int q = scan.nextInt();
        boolean isValidRange = false;

        if(p == 1) {
            System.out.print(1 + " ");
            isValidRange = true;
            p = 4;
        }
        for(long i = p; i <=q; ++i) {
            String num = String.valueOf(i);
            String square = String.valueOf(i * i);

            if(square.length() > 1) {
                int left = Integer.parseInt(square.substring(0, square.length() - num.length()));
                int right = Integer.parseInt(square.substring(square.length() - num.length()));

                if(left + right == i) {
                    isValidRange = true;
                    System.out.print(i + " ");
                }
            }
        }

        if(!isValidRange) {
            System.out.println("INVALID RANGE");
        }
    }
}
