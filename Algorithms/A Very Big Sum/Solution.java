// PROBLEM LINK: https://www.hackerrank.com/challenges/a-very-big-sum

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scan= new Scanner(System.in);
        int inputLength = scan.nextInt();
        
        long sum = 0;
        for(int i = 0; i < inputLength; i++)
            sum += scan.nextInt();

        System.out.println(sum);
    }
}