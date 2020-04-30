/**
 * Problem Link - https://www.hackerrank.com/challenges/the-time-in-words
 */

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int h = scan.nextInt();
        int m = scan.nextInt();

        HashMap<Integer, String> intToWord = new HashMap<>();
        intToWord.put(1, "one"); intToWord.put(2, "two");
        intToWord.put(3, "three"); intToWord.put(4, "four");
        intToWord.put(5, "five"); intToWord.put(6, "six");
        intToWord.put(7, "seven"); intToWord.put(8, "eight");
        intToWord.put(9, "nine"); intToWord.put(10, "ten");
        intToWord.put(11, "eleven"); intToWord.put(12, "twelve");
        intToWord.put(13, "thirteen"); intToWord.put(14, "fourteen");
        intToWord.put(15, "fifteen"); intToWord.put(16, "sixteen");
        intToWord.put(17, "seventeen"); intToWord.put(18, "eighteen");
        intToWord.put(19, "nineteen"); intToWord.put(20, "twenty");

        if (m == 0) {
            System.out.println(intToWord.get(h) + " o' clock");
        } else if (m == 1) {
            System.out.println(intToWord.get(m) + " minute past " + intToWord.get(h));
        } else if (m == 15) {
            System.out.println("quarter past " + intToWord.get(h));
        } else if (m == 30) {
            System.out.println("half past " + intToWord.get(h));
        } else if (m == 45) {
            System.out.println("quarter to " + intToWord.get((h + 1) % 12));
        } else if (m < 30) {
            if (m <= 20) {
                System.out.println(intToWord.get(m) + " minutes past " + intToWord.get(h));
            } else {
                System.out.println("twenty " + intToWord.get(m - 20) + " minutes past " + intToWord.get(h));
            }
        } else if (m > 30) {
            if (m >= 40) {
                System.out.println(intToWord.get(60 - m) + " minutes to " + intToWord.get((h + 1) % 12));
            } else {
                System.out.println("twenty " + intToWord.get(60 - m - 20) + " minutes to " + intToWord.get((h + 1) % 12));
            }
        }
    }
}
