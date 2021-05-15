/**
 * Problem Link - https://www.hackerrank.com/contests/inzva-algorithm-competition-league-2-contest-3/challenges/fallen-keys/problem
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

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
			List<Character> broken = new ArrayList<>();
			String s = in.next();
			for (int i = 0; i < n; ++i) {
				broken.add(s.charAt(i));
			}

			int m = in.nextInt();
			String sent = in.next();
			List<Character> chars = new ArrayList<>();

			for (int i = 0; i < m; ++i) {
				if (!chars.contains(sent.charAt(i))) {
					chars.add(sent.charAt(i));
				}
			}

			int notUse = 0;
			for (char c : broken) {
				if (!chars.contains(c)) {
					++notUse;
				}
			}

			int outOfUse = chars.size() + notUse;
			int required = broken.size() - notUse;
			if (26 - outOfUse >= required) {
				out.println(required);
			} else {
				out.println(-1);
			}
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
