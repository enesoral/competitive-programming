// PROBLEM LINK: https://www.hackerrank.com/challenges/the-birthday-bar

import java.util.*;

public class Solution {

    private static int getWays(int[] s, int d, int m) {
        int countWays = 0, countAddend = 0, sum = 0;

        for (int i = 0; i < s.length; i++) {
            sum += s[i];
            countAddend++;
            
            if (countAddend == m)  {
                if (sum == d) countWays++;
                
                countAddend = 0;
                sum = 0; 
                i -= m - 1;
            }
        }

        return countWays;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] squares = new int[n];

        for(int i = 0; i < n; i++)
            squares[i] = scanner.nextInt();

        int day = scanner.nextInt();
        int month = scanner.nextInt();

        int result = getWays(squares, day, month);

        System.out.println(result);
        scanner.close();
    }
}