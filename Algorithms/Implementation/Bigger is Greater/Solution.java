/**
 * Problem Link - https://www.hackerrank.com/challenges/bigger-is-greater
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();

        while(T-- > 0) {
            StringBuilder str = new StringBuilder(scan.nextLine());

            int i = str.length() - 1;
            while (i > 0 && str.charAt(i - 1) >= str.charAt(i)) {
                --i;
            }

            if(i <= 0) {
                System.out.println("no answer");
                continue;
            }

            int j = str.length() - 1;
            while(str.charAt(j) <= str.charAt(i - 1)) {
                --j;
            }

            char temp = str.charAt(j);
            str.setCharAt(j, str.charAt(i - 1));
            str.setCharAt(i - 1, temp);

            j = str.length() - 1;
            while (i < j) {
                temp = str.charAt(i);
                str.setCharAt(i, str.charAt(j));
                str.setCharAt(j, temp);
                ++i;
                --j;
            }

            System.out.println(str);
        }
    }
}
