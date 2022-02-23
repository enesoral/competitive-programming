/**
 * Problem Link -
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Solution1 {

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

            LinkedList reverseList = reverseList(list);
            out.println(isHalfOfItSame(list, reverseList, n));
        }

        private LinkedList reverseList(LinkedList list) {
            LinkedList.Node curr = list.head;
            LinkedList.Node head = null;
            while (curr != null) {
                LinkedList.Node node = new LinkedList.Node(curr.data);
                node.next = head;
                head = node;
                curr = curr.next;
            }
            return new LinkedList(head);
        }

        private boolean isHalfOfItSame(LinkedList list, LinkedList reverseList, int size) {
            LinkedList.Node node1 = list.head;
            LinkedList.Node node2 = reverseList.head;
            int iteration = size / 2;
            while (node1 != null && node2 != null) {
                if (node1.data != node2.data) {
                    return false;
                }

                iteration--;
                if (iteration == 0) {
                    return true;
                }

                node1 = node1.next;
                node2 = node2.next;
            }

            return node1 == null && node2 == null;
        }
    }

    static class LinkedList {
        Node head;

        public LinkedList() {
        }

        public LinkedList(Node head) {
            this.head = head;
        }

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
