/**
 * Problem Link - https://www.hackerrank.com/challenges/lisa-workbook
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte n = scan.nextByte();
        byte k = scan.nextByte();

        int page = 0;
        byte countSpecialProblems = 0;
        for (int i = 0; i < n; ++i) {
            byte problems = scan.nextByte();

            int numberOfFirstQuestionOnPage = 0;
            for (int j = 1; j <= problems; ) {
                if (j % k == 1 || k == 1) {
                    ++page;
                    numberOfFirstQuestionOnPage = j;
                }

                if (j == page) {
                    ++countSpecialProblems;
                    j = numberOfFirstQuestionOnPage + k;  // if found go to next page
                    continue;
                }
                
                ++j;
            }
        }
        System.out.println(countSpecialProblems);
    }
}
