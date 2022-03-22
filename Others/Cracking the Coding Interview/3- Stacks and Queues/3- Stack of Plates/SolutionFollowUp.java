/**
 * Problem: Start a new stack when the previous stack exceeds some threshold.
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.InputMismatchException;

public class SolutionFollowUp {

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
            stack.push(7);
            stack.push(4);
            stack.push(8);
            stack.push(3);

            stack.popAt(0);
            stack.pop();
            stack.pop();
        }
    }

    static class Stack<T> {
        static class StackNode<T> {
            private T data;
            private StackNode<T> above;
            private StackNode<T> below;

            public StackNode(T data) {
                this.data = data;
            }
        }

        private StackNode<T> top;
        private StackNode<T> bottom;
        private int size = 0;

        public void push(T item) {
            StackNode<T> node = new StackNode<>(item);

            size++;
            if (size == 1) this.bottom = node;
            join(node, top);
            top = node;
        }

        public T pop() {
            if (top == null) throw new EmptyStackException();

            size--;
            T item = top.data;
            top = top.below;
            return item;
        }

        public void join(StackNode<T> above, StackNode<T> below) {
            if (below != null) below.above = above;
            if (above != null) above.below = below;
        }

        public T removeBottom() {
            T value = bottom.data;
            bottom = bottom.above;
            if (bottom != null) bottom.below = null;
            size--;
            return value;
        }

        public T peek() {
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public int size() {
            return size;
        }
    }

    static class SetOfStacks {
        private final int capacity;
        private final ArrayList<Stack<Integer>> stacks;
        private Stack<Integer> curr;

        public SetOfStacks(int capacity) {
            this.capacity = capacity;
            stacks = new ArrayList<>();
            stacks.add(new Stack<>());
            this.curr = getLastStack();
        }

        public Stack<Integer> getLastStack() {
            if (stacks.isEmpty()) return null;
            return stacks.get(stacks.size() - 1);
        }

        public void push(int value) {
            if (curr.size() == capacity) {
                System.out.println("Creating new stack for val: " + value);
                stacks.add(new Stack<>());
                this.curr = getLastStack();
            }
            curr.push(value);
        }

        public Integer pop() {
            if (curr.size() == 0) {
                System.out.println("Removing the latest stack..");
                stacks.remove(stacks.size() - 1);
                this.curr = getLastStack();
            }
            return curr.pop();
        }

        public int popAt(int index) {
            return leftShift(index, true);
        }

        private int leftShift(int index, boolean removeTop) {
            System.out.println("Shifting stack " + (index + 1));
            Stack<Integer> stack = stacks.get(index);
            int removedItem;
            if (removeTop) {
                removedItem = stack.pop();
            } else {
                removedItem = stack.removeBottom();
            }

            if (stack.isEmpty()) {
                stacks.remove(index);
            } else if (stacks.size() > index + 1) {
                int v = leftShift(index + 1, false);
                stack.push(v);
                System.out.println("Shifted val: " + v);
            }

            System.out.println("Shifted stack " + (index + 1));
            return removedItem;
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
