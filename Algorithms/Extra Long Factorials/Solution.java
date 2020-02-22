/**
 * Problem Link - https://www.hackerrank.com/challenges/extra-long-factorials
 */

import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
	
        BigInteger factorial = new BigInteger("1");
        for(int i = 2; i <= num; ++i){
           factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);
        scanner.close();
    }
}
