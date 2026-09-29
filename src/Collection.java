import java.util.*;

public class Collection {
    public static void main(String[] args) {
        int N = 20;
        Random random = new Random();

        // 1. Массив из N случайных чисел от 0 до 100
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(101);
        }
        System.out.println("1. Исходный массив: " + Arrays.toString(array));

        // 2. Список на основе массива
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("2. Список: " + list);

        // 3. Сортировка по возрастанию
        Collections.sort(list);
        System.out.println("3. По возрастанию: " + list);

        // 4. Сортировка в обратном порядке
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("4. По убыванию: " + list);

        // 5. Перемешивание
        Collections.shuffle(list);
        System.out.println("5. Перемешанный список: " + list);

        // 6. Циклический сдвиг на 1 элемент
        Collections.rotate(list, 1);
        System.out.println("6. После циклического сдвига на 1: " + list);

        // Подсчёт частот для текущего списка
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (Integer value : list) {
            frequencies.put(value, frequencies.getOrDefault(value, 0) + 1);
        }

        // 7. Только уникальные элементы — те, которые встречаются один раз
        List<Integer> unique = new ArrayList<>(list);
        unique.removeIf(value -> frequencies.get(value) > 1);
        System.out.println("7. Только уникальные элементы: " + unique);

        // 8. Только дублирующиеся элементы — те, которые встречаются больше одного раза
        List<Integer> duplicates = new ArrayList<>(list);
        duplicates.removeIf(value -> frequencies.get(value) == 1);
        System.out.println("8. Только дублирующиеся элементы: " + duplicates);

        // 9. Получение массива из списка
        Integer[] fromList = list.toArray(new Integer[0]);
        System.out.println("9. Массив из списка: " + Arrays.toString(fromList));

        // 10. Подсчёт количества вхождений каждого числа
        Map<Integer, Integer> originalFreq = new TreeMap<>();
        for (Integer value : array) {
            originalFreq.put(value, originalFreq.getOrDefault(value, 0) + 1);
        }

        System.out.println("10. Частота вхождений чисел в исходном массиве:");
        for (Map.Entry<Integer, Integer> entry : originalFreq.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}