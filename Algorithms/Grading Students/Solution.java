// PROBLEM LINK: https://www.hackerrank.com/challenges/grading

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gradesSize = scanner.nextInt();
        int[] grades = new int[gradesSize];

        for(int i = 0; i < gradesSize; i++)
            grades[i] = scanner.nextInt();

        int[] roundedGrades = roundGrades(grades);

        for (int grade: roundedGrades) 
            System.out.println(grade);
    }

    private static int[] roundGrades(int[] grades) {
        int[] roundedGrades = new int[grades.length];

        int i = 0;
        for(int grade : grades) {
            if (grade >= 38) {
                if (grade % 5 >= 3)
                    grade += (5 - grade % 5);
            }
            roundedGrades[i] = grade;
            i++;
        }
        return roundedGrades;
    }
}