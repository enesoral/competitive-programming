/**
 * Problem Link - https://www.hackerrank.com/challenges/acm-icpc-team
 */

import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        BigInteger[] topic = new BigInteger[n];
        for (int i = 0; i < n; ++i) {
            topic[i] = new BigInteger(scanner.nextLine(), 2);
        }
        scanner.close();

        int countTeam = 0, maxSkills = 0;
        for (int i = 0; i < topic.length; ++i) {
            for (int j = i + 1; j < topic.length; ++j) {
                int oneCount = topic[i].or(topic[j]).bitCount();
                if (oneCount > maxSkills) {
                    maxSkills = oneCount;
                    countTeam = 1;
                } else if (oneCount == maxSkills) {
                    ++countTeam;
                }
            }
        }
        System.out.println(maxSkills + "\n" + countTeam);
    }
}
