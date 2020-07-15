// PROBLEM LINK: https://www.hackerrank.com/challenges/staircase

import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        StringBuilder output = new StringBuilder("");

        for(int i = 0; i < n; i++)
            output.append(" ");

        for(int i = 1; i< n + 1; i++) {
            output.setCharAt(n - i, '#');
            System.out.println(output);
        }
	
	scan.close();
    }
}