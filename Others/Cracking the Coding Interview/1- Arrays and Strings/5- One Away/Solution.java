/**
 * Problem Link - https://www.interviewcake.com/question/java/reverse-string-in-place
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Solution2 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    static class Solver {
        public void solve(InputReader in, PrintWriter out) {
            String str1 = in.next();
            String str2 = in.next();

            String shorter = str1.length() < str2.length() ? str1 : str2;
            String longer = str1.length() >= str2.length() ? str1 : str2;
            out.println(isOneAway(shorter, longer));
        }

        private boolean isOneAway(String shorter, String longer) {
            if (longer.length() - shorter.length() > 1) {
                return false;
            }

            int shorterIndex = 0;
            int longerIndex = 0;

            boolean hasDiffAlreadyFound = false;
            while (shorterIndex < shorter.length() && longerIndex < longer.length()) {
                if (shorter.charAt(shorterIndex) != longer.charAt(longerIndex)) {
                    if (hasDiffAlreadyFound) {
                        return false;
                    }
                    hasDiffAlreadyFound = true;

                    if (shorter.length() == longer.length()) {
                        shorterIndex++;
                    }
                } else {
                    shorterIndex++;
                }
                longerIndex++;
            }

            return true;
        }

        public int[] getFrequencyArray(String str) {
            int[] frequencies = new int[256];
            for (int i = 0; i < str.length(); i++) {
                frequencies[str.charAt(i)]++;
            }
            return frequencies;
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
