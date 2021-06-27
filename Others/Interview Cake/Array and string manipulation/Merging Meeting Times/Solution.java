/**
 * Problem Link - https://www.interviewcake.com/question/java/merging-ranges
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;

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
            int n = in.nextInt();
            List<Meeting> meetings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                meetings.add(new Meeting(start, end));
            }

            final List<Meeting> mergedMeetings = mergeRanges(meetings);
            out.println(mergedMeetings);
        }

        public List<Meeting> mergeRanges(List<Meeting> meetings) {
            List<Meeting> result = new ArrayList<>();
            meetings.sort(Comparator.comparing(Meeting::getStartTime));
            for (int i = 1; i < meetings.size(); i++) {
                Meeting me1 = meetings.get(i - 1);
                Meeting me2 = meetings.get(i);
                int st1 = me1.getStartTime();
                int end1 = me1.getEndTime();
                int st2 = me2.getStartTime();
                int end2 = me2.getEndTime();

                if (st2 <= end1) {
                    me2.setStartTime(st1);
                    me2.setEndTime(Math.max(end1, end2));
                } else {
                    result.add(me1);
                }

                if (i == meetings.size() - 1)
                    result.add(me2);
            }

            return result;
        }

        public static class Meeting {

            private int startTime;
            private int endTime;

            public Meeting(int startTime, int endTime) {
                // number of 30 min blocks past 9:00 am
                this.startTime = startTime;
                this.endTime   = endTime;
            }

            public int getStartTime() {
                return startTime;
            }

            public void setStartTime(int startTime) {
                this.startTime = startTime;
            }

            public int getEndTime() {
                return endTime;
            }

            public void setEndTime(int endTime) {
                this.endTime = endTime;
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
