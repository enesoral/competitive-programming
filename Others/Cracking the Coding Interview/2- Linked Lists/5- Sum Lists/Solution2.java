/**
 * Problem Link -
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
            int n = in.nextInt();
            LinkedList list1 = new LinkedList();
            for (int i = 0; i < n; i++) {
                list1.add(in.nextInt());
            }

            int k = in.nextInt();
            LinkedList list2 = new LinkedList();
            for (int i = 0; i < k; i++) {
                list2.add(in.nextInt());
            }

            out.print("\nForward result: ");
            printList(sumForwardLists(list1, list2), out);
        }

        /* Solution for forward order */
        static class PartialSum {
            public int carry = 0;
            public LinkedList.Node sum = null;
        }

        LinkedList sumForwardLists(LinkedList list1, LinkedList list2) {
            int length1 = getLength(list1);
            int length2 = getLength(list2);

            if (length1 > length2) {
                padListWithZeros(list2, length1 - length2);
            } else if (length2 > length1) {
                padListWithZeros(list1, length2 - length1);
            }

            PartialSum partialSum = sumListsHelper(list1.head, list2.head);

            if (partialSum.carry != 0) {
                partialSum.sum = insertBefore(partialSum.sum, partialSum.carry);
            }

            return new LinkedList(partialSum.sum);
        }

        private int getLength(LinkedList list) {
            LinkedList.Node curr = list.head;
            int count = 0;
            while (curr != null) {
                ++count;
                curr = curr.next;
            }
            return count;
        }

        private void padListWithZeros(LinkedList list, int numberOfZeros) {
            for (int i = 0; i < numberOfZeros; i++) {
                insertBefore(list.head, 0);
            }
        }

        private LinkedList.Node insertBefore(LinkedList.Node node, int data) {
            LinkedList.Node newHead = new LinkedList.Node(data);
            newHead.next = node;
            return newHead;
        }

        PartialSum sumListsHelper(LinkedList.Node node1, LinkedList.Node node2) {
            if (node1 == null && node2 == null) {
                return new PartialSum();
            }

            PartialSum partialSum = sumListsHelper(node1.next, node2.next);

            int data = node1.data + node2.data + partialSum.carry;

            partialSum.sum = insertBefore(partialSum.sum, data % 10);
            partialSum.carry = data < 10 ? 0 : 1;
            return partialSum;
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
