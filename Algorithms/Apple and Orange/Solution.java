// PROBLEM LINK: https://www.hackerrank.com/challenges/apple-and-orange

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[] apples = new int[m];
        
        for (int i = 0; i < m; i++) 
            apples[i] = scanner.nextInt();
        
        int[] oranges = new int[n];

        for (int i = 0; i < n; i++)
            oranges[i] = scanner.nextInt();
        
        int applesCount = 0, orangesCount = 0;

        for(int i : apples)
            if(a + i >= s && a + i <= t)
                applesCount++;
            
        for(int i : oranges)
            if(b + i >= s && b + i <= t)
                orangesCount++;

        System.out.println(applesCount);
        System.out.println(orangesCount);

        scanner.close();
    }
}