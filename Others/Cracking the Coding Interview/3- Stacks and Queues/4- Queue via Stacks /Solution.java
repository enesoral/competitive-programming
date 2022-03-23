/**
 * Problem: Implement a MyQueue class which implements a queue using two stacks.
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.EmptyStackException;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        Solver solver = new Solver();
        solver.solve();
    }

    static class Solver {
        public void solve() {
            MyQueue queue = new MyQueue();
            queue.add(1);
            queue.add(2);
            queue.add(3);

            System.out.println("Removed val: " + queue.remove());

            queue.add(4);
            queue.add(5);

            System.out.println("Removed val: " + queue.remove());
            System.out.println("Removed val: " + queue.remove());
            System.out.println("Removed val: " + queue.remove());
            System.out.println("Removed val: " + queue.remove());
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

        public T pop() {
            if (top == null) throw new EmptyStackException();

            T item = top.data;
            top = top.next;
            return item;
        }

        public void push(T item) {
            StackNode<T> node = new StackNode<>(item);
            node.next = top;
            top = node;
        }

        public T peek() {
            if (top == null) throw new EmptyStackException();

            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    static class MyQueue {
        private Stack<Integer> newest;
        private Stack<Integer> oldest;

        public MyQueue() {
            this.newest = new Stack<>();
            this.oldest = new Stack<>();
        }

        public void add(int value) {
            newest.push(value);
        }

        public int remove() {
            shiftStacks();
            return oldest.pop();
        }

        public int peek() {
            shiftStacks();
            return oldest.peek();
        }

        private void shiftStacks() {
            if (oldest.isEmpty()) {
                System.out.println("Shifting stacks..");
                while (!newest.isEmpty()) {
                    oldest.push(newest.pop());
                }
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
