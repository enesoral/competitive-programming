/**
 * Problem Link - https://www.hackerrank.com/challenges/almost-sorted
 *
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = in.nextInt();
		}

		String result = solve(arr);
		System.out.println(result);
	}

	private static String solve(int[] arr) {
		int[] sorted = Arrays.stream(arr).sorted().toArray();
		List<Integer> diff = compare(arr, sorted);

		if (diff.isEmpty()) {
			return "yes";
		} else if (diff.size() == 2) {
			return String.format("yes \nswap %d %d", diff.get(0) + 1, diff.get(1) + 1);
		} else if (diff.size() > 2) {
			reverse(arr, diff.get(0), diff.get(diff.size() - 1));
			if (compare(arr, sorted).isEmpty()) {
				return String.format("yes \nreverse %d %d", diff.get(0) + 1, diff.get(diff.size() - 1) + 1);
			}
		}
		return "no";
	}

	private static List<Integer> compare(int arr[], int[] sorted) {
		return IntStream.range(0, arr.length).filter(i -> arr[i] != sorted[i]).boxed().collect(Collectors.toList());
	}

	private static void reverse(int[] arr, Integer firstDiffIndex, Integer lastDiffIndex) {
		for (int i = firstDiffIndex, j = lastDiffIndex; i < j; ++i, --j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
