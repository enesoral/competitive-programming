// PROBLEM LINK: https://www.hackerrank.com/challenges/plus-minus

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arrSize = scan.nextInt();
        double positive = 0, negative = 0, zero = 0;

        for (int i = 0; i < arrSize; i++) {
            int value = scan.nextInt();

            positive += (value > 0) ? 1 : 0;
            negative += (value < 0) ? 1 : 0;
            zero += (value == 0) ? 1 : 0;
        }

        System.out.println(positive / arrSize);
        System.out.println(negative / arrSize);
        System.out.println(zero / arrSize);
        
        scan.close();
    }
}