import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 10;
        PrimesGenerator generator = new PrimesGenerator(N);

        System.out.println("Простые числа в прямом порядке:");
        Iterator<Integer> iterator = generator.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        List<Integer> primes = new ArrayList<>();
        Iterator<Integer> iterator2 = generator.iterator();
        while (iterator2.hasNext()) {
            primes.add(iterator2.next());
        }

        System.out.println("Простые числа в обратном порядке:");
        ListIterator<Integer> reverseIterator = primes.listIterator(primes.size());
        while (reverseIterator.hasPrevious()) {
            System.out.print(reverseIterator.previous() + " ");
        }
        System.out.println();
    }
}