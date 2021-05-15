/**
 * Problem Link - https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff08/0000000000387174
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Solution {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		AlienPiano solver = new AlienPiano();
		int T = Integer.parseInt(in.next());
		for (int i = 1; i <= T; ++i)
			solver.solve(i, in, out);
		out.close();
	}

	static class AlienPiano {
		public void solve (int testNumber, InputReader in, PrintWriter out) {
			int N = in.nextInt();
			int[] A = new int[N];

			for (int i = 0; i < N; ++i)
				A[i] = in.nextInt();

			int ans = 0;
			int upCount = 0;
			int downCount = 0;
			for (int i = 1; i < N; ++i) {
				if (A[i] > A[i - 1]) {
					++upCount;
					downCount = 0;
				} else if (A[i] < A[i - 1]) {
					++downCount;
					upCount = 0;
				}

				if (upCount > 3 || downCount > 3) {
					++ans;
					upCount = downCount = 0;
				}
			}

			out.println("Case #" + testNumber + ": " + ans);
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
				} catch (IOException e) {
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
