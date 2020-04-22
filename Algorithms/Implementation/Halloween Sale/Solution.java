/**
 * Problem Link - https://www.hackerrank.com/challenges/halloween-sale
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int openPrice = scan.nextInt();
        int diff = scan.nextInt();
        int minPrice = scan.nextInt();
        int myMoney = scan.nextInt();

        int numberOfGift = 0;
        if (myMoney >= openPrice) {
            numberOfGift = 1 + (openPrice - minPrice) / diff;
            int totalPriceBetweenPAndM = numberOfGift * (2 * openPrice - diff * (numberOfGift - 1)) / 2;
            if(myMoney >= totalPriceBetweenPAndM) {
                numberOfGift += (myMoney - totalPriceBetweenPAndM) / minPrice;
            } else {
                int x = 2 * openPrice + diff;
                numberOfGift = (int) ((x - Math.sqrt(x * x - 8 * diff * myMoney)) / (2 * diff));
            }
        }
        System.out.println(numberOfGift);
    }
}
