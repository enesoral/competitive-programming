/**
 * Problem Link - https://www.hackerrank.com/challenges/larrys-array
 *
 * Another solution - https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
 */
 
import java.util.Scanner

public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while (T-- > 0) {
			int n = in.nextInt();
			int[] A = new int[];
			for (int i = 0; i < n; ++i) {
				A[i] = in.nextInt();
			}
			
			for (int i = 0; i < n - 2; ++i) {
				for (int j = n - 2 - 1; j >= i; --j) {
					while (A[j] > A[j + 1] || A[j] > A[j + 2]) {
						int temp = A[j];
						A[j] = A[j + 1];
						A[j + 1] = A[j + 2];
						A[j + 2] = temp;
					}
				}
			}
			
			System.out.println(A[n - 2] < A[n - 1] ? "YES" : "NO");
		}
	}
}

