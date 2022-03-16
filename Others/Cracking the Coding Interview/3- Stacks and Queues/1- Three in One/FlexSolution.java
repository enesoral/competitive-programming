/**
 * Problem: Use a single array to implement three stacks.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.InputMismatchException;

public class FlexSolution {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    static class Solver {
        public void solve(InputReader in, PrintWriter out) {
            MultiStack stack = new MultiStack(3, 3);
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

            stack.push(1, 8);
            stack.push(1, 6);
            stack.push(1, 6);
            stack.push(1, 9);

            stack.printStack();
        }
    }

    static class MultiStack {
        private class StackInfo {
            public int start, size, capacity;
            public StackInfo(int start, int capacity) {
                this.start = start;
                this.capacity = capacity;
            }

            public boolean isWithinStackCapacity(int index) {
                if (index < 0 || index >= values.length) return false;

                int contiguousIndex = index < start ? index + values.length : index;
                int end = start + capacity;
                return start <= contiguousIndex && contiguousIndex < end;
            }

            public int lastCapacityIndex() {
                return adjustIndex(start + capacity - 1);
            }
            public int lastElementIndex() {
                return adjustIndex(start + size - 1);
            }

            public boolean isFull() {
                return size == capacity;
            }

            public boolean isEmpty() {
                return size == 0;
            }
        }

        private StackInfo[] info;
        private int[] values;

        public MultiStack(int numberOfStacks, int defaultSize) {
            info = new StackInfo[numberOfStacks];
            for (int i = 0; i < numberOfStacks; i++) {
                info[i] = new StackInfo(defaultSize * i, defaultSize);
            }
            values = new int[defaultSize * numberOfStacks];
        }

        public void push(int stackNum, int value) {
            if (allStacksAreFull()) {
                throw new OutOfMemoryError();
            }

            StackInfo stack = info[stackNum];
            if (stack.isFull()) {
                expand(stackNum);
            }

            stack.size++;
            values[stack.lastElementIndex()] = value;
        }

        public int pop(int stackNum) {
            StackInfo stack = info[stackNum];
            if (stack.isEmpty()) throw new EmptyStackException();

            int value = values[stack.lastElementIndex()];
            values[stack.lastElementIndex()] = 0;
            stack.size--;
            return value;
        }

        public int peek(int stackNum) {
            StackInfo stack = info[stackNum];
            return values[stack.lastElementIndex()];
        }

        public int numberOfElements() {
            int size = 0;
            for (StackInfo sd : info) {
                size += sd.size;
            }
            return size;
        }

        public boolean allStacksAreFull() {
            return numberOfElements() == values.length;
        }

        private void expand(int stackNum) {
            shift((stackNum + 1) % info.length);
            info[stackNum].capacity++;
        }

        private void shift(int stackNum) {
            System.out.println("Shifting stack: " + stackNum);
            StackInfo stack = info[stackNum];

            if (stack.size >= stack.capacity) {
                int nextStack = (stackNum + 1) % info.length;
                shift(nextStack);
                stack.capacity++;
            }

            int index = stack.lastCapacityIndex();
            while (stack.isWithinStackCapacity(index)) {
                values[index] = values[previousIndex(index)];
                index = previousIndex(index);
            }

            values[stack.start] = 0;
            stack.start = nextIndex(stack.start);
            stack.capacity--;
        }

        private int adjustIndex(int index) {
            int max = values.length;
            return ((index % max) + max) % max;
        }

        private int nextIndex(int index) {
            return adjustIndex(index + 1);
        }

        private int previousIndex(int index) {
            return adjustIndex(index - 1);
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
