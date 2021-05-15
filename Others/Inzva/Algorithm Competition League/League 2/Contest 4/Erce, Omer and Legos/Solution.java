/**
 * Problem Link - https://www.hackerrank.com/contests/inzva-algorithm-competition-league-2-contest-4/challenges/erce-omer-and-legos
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Solver solver = new Solver();
		solver.solve(in, out);
		out.close();
	}

	static class Solver {

		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			boolean[] data = new boolean[10000000];
			for (int i = 1; i <= n; ++i) {
				int a = in.nextInt();
				if (!map.containsKey(a)) {
					map.put(a, 1);
				} else {
					map.put(a, map.get(a) + 1);
				}
				data[a] = true;
			}

			long count = 0;
			for (int key : map.keySet()) {
				int keyVal = map.get(key);
				if (keyVal > 1) {
					int start = key + 1;
					for (int x = 0; x < keyVal - 1; ++x) {
						for (int i = start; i < 10000000; ++i) {
							if (!data[i]) {
								count += i - key;
								start = i + 1;
								data[i] = true;
								break;
							}
						}
					}
				}
			}
			out.println(count);
		}
	}

	static class InputReader {

		private InputStream stream;

		private byte[] buf = new byte[1024];

		private int curChar;

		private int numChars;

		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		private int read() {
			if (numChars == -1)
				throw new InputMismatchException();

			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				}
				catch (IOException e) {
					throw new InputMismatchException();
				}

				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = read();

			while (isSpaceChar(c))
				c = read();

			int sgn = 1;

			if (c == '-') {
				sgn = -1;
				c = read();
			}

			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c));

			return res * sgn;
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;

			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c));
			return res * sgn;
		}

		private String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			}
			while (!isSpaceChar(c));

			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() {
			return readString();
		}

		public interface SpaceCharFilter {

			boolean isSpaceChar(int ch);

		}
	}
}
