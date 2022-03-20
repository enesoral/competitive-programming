/**
 * Problem: Design a stack which, in addition to push and pop, has a function min which returns the minimum element?
 *          Push, pop and min should all operate in O(1) time.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Objects;

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
            StackWithMin stack = new StackWithMin();
            stack.push(5);
            stack.push(2);
            stack.push(6);
            stack.push(3);
            stack.push(1);

            stack.print(out);
            out.println("Min: " + stack.min());

            stack.pop();

            stack.print(out);
            out.println("Min: " + stack.min());
        }
    }

    static class Stack<T> {
        static class StackNode<T> {
            private T data;
            private StackNode<T> next;

            public StackNode(T data) {
                this.data = data;
            }
        }

        private StackNode<T> top;

        public void push(T item) {
            StackNode<T> node = new StackNode<>(item);
            node.next = top;
            top = node;
        }

        public T pop() {
            if (top == null) throw new EmptyStackException();

            T item = top.data;
            top = top.next;
            return item;
        }

        public T peek() {
            if (top == null) throw new EmptyStackException();

            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void print(PrintWriter out) {
            StackNode<T> node = top;
            while (node != null) {
                out.print(node.data + " ");
                node = node.next;
            }
            out.println();
        }
    }

    static class StackWithMin extends Stack<Integer> {
        private final Stack<Integer> minimums;

        public StackWithMin() {
            minimums = new Stack<>();
        }

        public void push(int value) {
            if (value <= min()) {
                minimums.push(value);
            }
            super.push(value);
        }

        public Integer pop() {
            final Integer value = super.pop();
            if(Objects.equals(value, minimums.peek())) {
                minimums.pop();
            }
            return value;
        }

        public Integer min() {
            if (minimums.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return minimums.peek();
            }
        }

        public void print(PrintWriter out) {
            super.print(out);
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
