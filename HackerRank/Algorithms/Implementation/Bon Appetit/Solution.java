/**
 * Problem Link - https://www.hackerrank.com/challenges/bon-appetit
 */

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {

    private static void bonAppetit(List<Integer> bill, int k, int b) {

            int annaCharged = 0;

            for (int i = 0; i < bill.size(); i++) {
                if(i == k)  continue;

                annaCharged += bill.get(i);
            }

            annaCharged /= 2;

        System.out.println((annaCharged == b) ? "Bon Appetit" : (b - annaCharged));
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
