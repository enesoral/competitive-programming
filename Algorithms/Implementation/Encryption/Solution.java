/**
 * Problem Link - https://www.hackerrank.com/challenges/encryption
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        double ceil = Math.ceil(Math.sqrt(s.length()));

        StringBuilder encrypted = new StringBuilder();
        for(int i = 0; i < ceil; ++i) {
            for (int j = i; ; j += ceil) {
                if (j >= s.length()) {
                    break;
                }
                encrypted.append(s.charAt(j));
            }
            encrypted.append(' ');
        }
        System.out.println(encrypted);
    }
}
