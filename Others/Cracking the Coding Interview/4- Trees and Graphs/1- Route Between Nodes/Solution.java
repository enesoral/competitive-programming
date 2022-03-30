/**
 * Problem: Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
            Graph<Integer> graph = new Graph<>();

            graph.addEdge(0, 1, true);
            graph.addEdge(0, 4, true);
            graph.addEdge(1, 2, true);
            graph.addEdge(1, 3, true);
            graph.addEdge(1, 4, true);
            graph.addEdge(2, 3, true);
            graph.addEdge(3, 4, true);

            out.println(graph);

            boolean searchResult = search(graph, 0, 5);
            out.println(searchResult ? "Found!" : "Not Found!");
        }

        public boolean search(Graph<Integer> graph, int source, int destination) {
            Deque<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();

            queue.addFirst(source);

            while (!queue.isEmpty()) {
                int val = queue.removeFirst();
                if (val == destination) {
                    return true;
                }

                if (visited.contains(val)) {
                    continue;
                }
                visited.add(val);

                for (int adjacent : graph.getAdjacents(val)) {
                    queue.addLast(adjacent);
                }
            }

            return false;
        }
    }

    static class Graph<T> {
        private Map<T, List<T>> map = new HashMap<>();

        public void addVertex(T v) {
            map.put(v, new LinkedList<>());
        }

        public void addEdge(T source, T destination, boolean bidirectional) {
            if (!map.containsKey(source))
                addVertex(source);

            if (!map.containsKey(destination))
                addVertex(destination);

            map.get(source).add(destination);
            if (bidirectional)
                map.get(destination).add(source);
        }

        public List<T> getAdjacents(T source) {
            return map.getOrDefault(source, Collections.emptyList());
        }

        public int getEdgesCount(boolean bidirectional) {
            int count = 0;
            for (T v : map.keySet()) {
                count += map.get(v).size();
            }

            if (bidirectional) {
                count = count / 2;
            }

            return count;
        }

        public boolean hasVertex(T v) {
            return map.containsKey(v);
        }

        public boolean hasEdge(T s, T d) {
            return map.get(s).contains(d);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (T v : map.keySet()) {
                builder.append(v.toString() + ": ");
                for (T w : map.get(v)) {
                    builder.append(w.toString() + " ");
                }
                builder.append("\n");
            }
            return (builder.toString());
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
