// PROBLEM LINK: https://www.hackerrank.com/challenges/time-conversion

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();

        String result = timeConversion(s);

        System.out.println(result);
    }

    private static String timeConversion(String s) {
        String hr = "", rem = "";

        if (s.endsWith("PM") && !s.substring(0, 2).equals("12")) {
            hr = Integer.toString(12 + Integer.parseInt(s.substring(0, 2)));
            rem = s.substring(2, 8);
        } else if(s.endsWith("AM") && s.substring(0, 2).equals("12")) {
            hr = "00";
            rem = s.substring(2, 8);
        } else {
            rem = s.substring(0, 8);
        }

        return hr + rem;
    }
}