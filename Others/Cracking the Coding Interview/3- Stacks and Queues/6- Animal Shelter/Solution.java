/**
 * Problem: An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
 *          People must adopt either the "oldest" of all animals at the shelter, or they can select whether they would
 *          prefer a dog or a cat (and will receive the oldest animal of that type).
 *          Create the data structures to maintain this system.
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Solution {

    public static void main(String[] args) {
        Solver solver = new Solver();
        solver.solve();
    }

    static class Solver {
        public void solve() {
            Shelter shelter = new Shelter();
            shelter.enqueue(new Animal(Animal.Type.CAT));
            shelter.enqueue(new Animal(Animal.Type.CAT));
            shelter.enqueue(new Animal(Animal.Type.DOG));
            shelter.enqueue(new Animal(Animal.Type.CAT));
            shelter.enqueue(new Animal(Animal.Type.DOG));

            shelter.dequeueAny();
            shelter.dequeueCat();
            shelter.dequeueDog();
            shelter.dequeueAny();
        }
    }

    static class Shelter {
        private Queue<WaitingAnimal> cats;
        private Queue<WaitingAnimal> dogs;
        private int order;

        public Shelter() {
            this.cats = new Queue<>();
            this.dogs = new Queue<>();
            this.order = 0;
        }

        public void enqueue(Animal animal) {
            WaitingAnimal waitingAnimal = new WaitingAnimal(animal, ++order);
            if (Animal.Type.CAT.equals(animal.type)) {
                cats.push(waitingAnimal);
            } else {
                dogs.push(waitingAnimal);
            }
        }

        public Animal dequeueAny() {
            if (cats.isEmpty() && dogs.isEmpty()) {
                throw new NoSuchElementException();
            }

            if (cats.isEmpty()) {
                return dogs.remove().animal;
            } else if (dogs.isEmpty()) {
                return cats.remove().animal;
            }

            WaitingAnimal dog = dogs.peek();
            WaitingAnimal cat = cats.peek();
            if (cat.order < dog.order) {
                cats.remove();
                return cat.animal;
            } else {
                dogs.remove();
                return dog.animal;
            }
        }

        public Animal dequeueCat() {
            if (cats.isEmpty()) {
                throw new NoSuchElementException();
            }

            return cats.remove().animal;
        }

        public Animal dequeueDog() {
            if (dogs.isEmpty()) {
                throw new NoSuchElementException();
            }

            return dogs.remove().animal;
        }
    }

    static class WaitingAnimal {
        Animal animal;
        int order;

        public WaitingAnimal(Animal animal, int order) {
            this.animal = animal;
            this.order = order;
        }
    }

    static class Animal {
        enum Type {
            CAT, DOG
        }

        Type type;

        public Animal(Type type) {
            this.type = type;
        }
    }

    static class Queue<T> {
        static class QueueNode<T> {
            private T data;
            private QueueNode<T> next;

            public QueueNode(T data) {
                this.data = data;
            }
        }

        private QueueNode<T> first;
        private QueueNode<T> last;

        public void push(T item) {
            QueueNode<T> node = new QueueNode<>(item);
            if (last != null) {
                last.next = node;
            }
            last = node;
            if (first == null) {
                first = last;
            }
        }

        public T remove() {
            if (first == null) throw new NoSuchElementException();
            T data = first.data;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return data;
        }

        public T peek() {
            if (first == null) throw new NoSuchElementException();
            return first.data;
        }

        public boolean isEmpty() {
            return first == null;
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
