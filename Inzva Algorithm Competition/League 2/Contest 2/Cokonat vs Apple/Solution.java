/*
 * Problem Link - https://www.hackerrank.com/contests/inzva-algorithm-competition-league-2-contest-2/challenges/cokonat-vs-apple
 *
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long E = in.nextLong();
        long K = in.nextLong();
        long N = in.nextLong();

        long min = 0;
        long max = 0;
        if (N <= E) {
            min = E - N;
        } else {
            min = (N - E) % (E + K);
        }

        if (N <= K) {
            max = E + N;
        } else {
            max = E + K - ((N - K) % (E + K));
        }

        System.out.println(min +" "+max);
    }
}

