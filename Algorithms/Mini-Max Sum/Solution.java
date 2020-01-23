// PROBLEM LINK: https://www.hackerrank.com/challenges/mini-max-sum

import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++)
            arr[i] = scan.nextInt();

        int minNum = arr[0], maxNum = arr[0];
        long totalSum = arr[0];

        for(int i = 1; i < arr.length; i++) {
            totalSum += arr[i];

            if (arr[i] > maxNum)
                maxNum = arr[i];

            if (arr[i] < minNum)
                minNum = arr[i];
        }

        System.out.println((totalSum - maxNum)  + " " + (totalSum - minNum));

        scan.close();
    }
}