/**
 * Problem Link -
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

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
            int n = in.nextInt();
            LinkedList list = new LinkedList();
            for (int i = 0; i < n; i++) {
                list.add(in.nextInt());
            }

            removeDupsWithoutExtraSpace(list);

            printList(list, out);
        }

        private void removeDups(LinkedList list) {
            Set<Integer> set = new HashSet<>();
            LinkedList.Node prev = null;
            LinkedList.Node current = list.head;
            while(current != null) {
                if (set.contains(current.data)) {
                    prev.next = current.next;
                } else {
                    set.add(current.data);
                    prev = current;
                }
                current = current.next;
            }
        }

        private void removeDupsWithoutExtraSpace(LinkedList list) {
            LinkedList.Node curr = list.head;
            LinkedList.Node prev;
            LinkedList.Node runner;
            while (curr != null) {
                prev = curr;
                runner = curr.next;
                while (runner != null) {
                    if (curr.data == runner.data) {
                        prev.next = runner.next;
                    } else {
                        prev = runner;
                    }
                    runner = runner.next;
                }
                curr = curr.next;
            }
        }

        private void printList(LinkedList list, PrintWriter out) {
            LinkedList.Node current = list.head;
            while(current != null) {
                out.print(current.data + " - ");
                current = current.next;
            }
        }
    }

    static class LinkedList {
        Node head;

        static class Node {
            Node next = null;
            int data;

            public Node(int data) {
                this.data = data;
            }
        }

        public void add(int data) {
            Node newNode = new Node(data);

            if (this.head == null) {
                head = newNode;
            } else {
                Node last = this.head;
                while (last.next != null) {
                    last = last.next;
                }

                last.next = newNode;
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
