/**
 * Problem: Start a new stack when the previous stack exceeds some threshold.
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        Solver solver = new Solver();
        solver.solve();
    }

    static class Solver {
        public void solve() {
            SetOfStacks stack = new SetOfStacks(3);
            stack.push(5);
            stack.push(2);
            stack.push(6);
            stack.push(3);
            stack.push(1);

            stack.pop();
            stack.pop();
            stack.pop();
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

        private int size;
        private StackNode<T> top;

        public void push(T item) {
            StackNode<T> node = new StackNode<>(item);
            node.next = top;
            top = node;
            size++;
        }

        public T pop() {
            if (top == null) throw new EmptyStackException();

            size--;
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

        public int size() {
            return size;
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

    static class SetOfStacks {
        private final int capacity;
        private final Stack<Stack<Integer>> stacks;
        private Stack<Integer> curr;

        public SetOfStacks(int capacity) {
            this.capacity = capacity;
            stacks = new Stack<>();
            stacks.push(new Stack<>());
            this.curr = stacks.peek();
        }

        public void push(int value) {
            if (curr.size() == capacity) {
                System.out.println("Creating new stack for val: " + value);
                stacks.push(new Stack<>());
                this.curr = stacks.peek();
            }
            curr.push(value);
        }

        public Integer pop() {
            if (curr.size() == 0) {
                System.out.println("Removing the latest stack..");
                stacks.pop();
                this.curr = stacks.peek();
            }
            return curr.pop();
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
