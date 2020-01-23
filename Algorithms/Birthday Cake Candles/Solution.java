// PROBLEM LINK: https://www.hackerrank.com/challenges/birthday-cake-candles

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        int[] arr = new int[arrSize];

        for(int i = 0; i < arrSize; i++)
            arr[i] = scanner.nextInt();

        int result = birthdayCakeCandles(arr);
        System.out.println(result);

        scanner.close();
    }

    private static int birthdayCakeCandles(int[] arr) {
        int count = 0, maxVal = arr[0];

        for(int i = 0; i < arr.length; i++){
            if (maxVal < arr[i]){
                maxVal = arr[i];
                count = 1;
            } else if(maxVal == arr[i]) {
                count++;
            }
        }

        return count;
    }
}