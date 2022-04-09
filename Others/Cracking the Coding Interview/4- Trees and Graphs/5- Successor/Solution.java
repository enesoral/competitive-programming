/**
 * Problem: Implement a function to check if a binary tree is a binary search tree.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
            TreeNode node20 = new TreeNode(20);
            TreeNode node10 = new TreeNode(10);
            TreeNode node30 = new TreeNode(30);
            TreeNode node5 = new TreeNode(5);
            TreeNode node15 = new TreeNode(15);
            TreeNode node3 = new TreeNode(3);
            TreeNode node7 = new TreeNode(7);
            TreeNode node17 = new TreeNode(17);

            node5.left = node3;
            node5.right = node7;
            node7.parent = node3.parent = node5;
            node10.left = node5;
            node5.parent = node10;
            node15.right = node17;
            node17.parent = node15;
            node10.right = node15;
            node15.parent = node10;
            node20.left = node10;
            node20.right = node30;
            node10.parent = node30.parent = node20;

            out.println(inOrderSucc(node7));
        }

        public TreeNode inOrderSucc(TreeNode node) {
            if (node == null) return null;

            if (node.right != null) {
                return getLeftMostChild(node.right);
            } else {
                TreeNode curr = node;
                TreeNode parent = curr.parent;

                while (parent != null && parent.left != curr) {
                    curr = parent;
                    parent = parent.parent;
                }

                return parent;
            }
        }

        public TreeNode getLeftMostChild(TreeNode node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
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
                } catch (IOException e) {
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
