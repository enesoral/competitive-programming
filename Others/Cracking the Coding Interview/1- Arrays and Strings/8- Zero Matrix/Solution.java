/**
 * Problem Link - https://www.interviewcake.com/question/java/reverse-string-in-place
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

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
            int M = in.nextInt();
            int N = in.nextInt();
            int[][] arr = new int[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            zeroMatrix(arr);
            out.println(Arrays.deepToString(arr));
        }

        private void zeroMatrix(int[][] arr) {
            boolean hasFirstRowZero = hasFirstRowZero(arr);
            boolean hasFirstColumnZero = hasFirstColumnZero(arr);

            markRowsAndColumns(arr);

            zerofyRowsAndColumnsBasedOnMark(arr);

            if (hasFirstRowZero) {
                zerofyRow(arr, 0);
            }

            if (hasFirstColumnZero) {
                zerofyColumn(arr, 0);
            }
        }

        private boolean hasFirstRowZero(int[][] arr) {
            for (int i = 0; i < arr[0].length; i++) {
                if (arr[0][i] == 0) {
                    return true;
                }
            }

            return false;
        }

        private boolean hasFirstColumnZero(int[][] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] == 0) {
                    return true;
                }
            }

            return false;
        }

        private void markRowsAndColumns(int[][] arr) {
            for (int i = 1; i < arr.length; i++) {
                for (int j = 1; j < arr[0].length; j++) {
                    if (arr[i][j] == 0) {
                        arr[i][0] = 0;
                        arr[0][j] = 0;
                    }
                }
            }
        }

        private void zerofyRowsAndColumnsBasedOnMark(int[][] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] == 0) {
                    zerofyRow(arr, i);
                }
            }

            for (int j = 0; j < arr[0].length; j++) {
                if (arr[0][j] == 0) {
                    zerofyColumn(arr, j);
                }
            }
        }

        private void zerofyRow(int[][] arr, int row) {
            for (int i = 0; i < arr[0].length; i++) {
                arr[row][i] = 0;
            }
        }

        private void zerofyColumn(int[][] arr, int column) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][column] = 0;
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
