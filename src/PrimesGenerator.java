import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimesGenerator implements Iterable<Integer> {
    private final int count;

    public PrimesGenerator(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Количество чисел не может быть отрицательным");
        }
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int produced = 0;
            private int candidate = 2;

            @Override
            public boolean hasNext() {
                return produced < count;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                while (!isPrime(candidate)) {
                    candidate++;
                }

                int prime = candidate;
                candidate++;
                produced++;
                return prime;
            }
        };
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
