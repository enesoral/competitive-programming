/**
 * Problem: Use a single array to implement three stacks.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.InputMismatchException;

public class FixSolution {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    static class Solver {
        public void solve(InputReader in, PrintWriter out) {
            ArrayStack stack = new ArrayStack(3);
            stack.push(0, 1);
            stack.push(1, 4);
            stack.push(2, 7);
            stack.push(2, 8);
            stack.push(1, 5);
            stack.push(0, 2);
            stack.push(1, 6);
            stack.push(0, 3);
            stack.push(2, 9);

            stack.pop(2);
            stack.pop(2);
            stack.pop(0);
            stack.pop(1);

            stack.push(2, 8);
            stack.push(1, 6);
            stack.push(2, 9);
            stack.push(0, 3);

            stack.printStack();
        }
    }

    static class ArrayStack {
        private final int numberOfStacks = 3;
        private final int stackCapacity;
        private int[] sizes;
        private int[] values;

        public ArrayStack(int stackSize) {
            this.stackCapacity = stackSize;
            this.sizes = new int[numberOfStacks];
            this.values = new int[stackCapacity * numberOfStacks];
        }

        public void push(int stackNum, int value) {
            if (isFull(stackNum)) throw new IndexOutOfBoundsException();

            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }

        public int pop(int stackNum) {
            if (isEmpty(stackNum)) throw new EmptyStackException();

            int indexOfTop = indexOfTop(stackNum);
            int data = values[indexOfTop];
            values[indexOfTop] = 0;
            sizes[stackNum]--;
            return data;
        }

        public int peek(int stackNum) {
            if (isEmpty(stackNum)) throw new EmptyStackException();

            return values[indexOfTop(stackNum)];
        }

        private boolean isFull(int stackNum) {
            return sizes[stackNum] == stackCapacity;
        }

        private boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }

        private int indexOfTop(int stackNum) {
            int offset = stackNum * stackCapacity;
            int size = sizes[stackNum];
            return offset + size - 1;
        }

        public void printStack() {
            System.out.println(Arrays.toString(values));
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
