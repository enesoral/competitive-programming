/**
 * Problem Link - https://www.hackerrank.com/challenges/flatland-space-stations
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        boolean[] hasStation = new boolean[n];
        for (int i = 0; i < m; ++i) {
            int city = scan.nextInt();
            hasStation[city] = true;
        }

        int maxDistance = 0;
        int lastStation = -1;
        for (int city = 0; city < n; ++city) {
            if (hasStation[city]) {
                if (lastStation == -1) {
                    maxDistance = city;
                } else if ((city - lastStation) / 2 > maxDistance) {
                    maxDistance = (city - lastStation) / 2;
                }
                lastStation = city;
            }
        }

        int distanceBetweenLastCityAndLastStation = n - 1 - lastStation;

        System.out.println(Math.max(distanceBetweenLastCityAndLastStation, maxDistance));
    }
}
