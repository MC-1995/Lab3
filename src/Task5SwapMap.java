import java.util.*;

public class Task5SwapMap {
    public static <K, V> Map<V, K> swap(Map<K, V> source) {
        Map<V, K> result = new HashMap<>();
        for (Map.Entry<K, V> entry : source.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> original = new LinkedHashMap<>();
        original.put("один", 1);
        original.put("два", 2);
        original.put("три", 3);

        System.out.println("Исходная Map: " + original);

        Map<Integer, String> swapped = swap(original);
        System.out.println("Обменянная Map: " + swapped);

        // Пример с неуникальными значениями:
        Map<String, Integer> withDuplicates = new LinkedHashMap<>();
        withDuplicates.put("a", 1);
        withDuplicates.put("b", 1);

        System.out.println("При дублирующихся значениях часть ключей перезапишется: "
                + swap(withDuplicates));
    }
}