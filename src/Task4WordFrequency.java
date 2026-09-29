import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task4WordFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст на английском языке (можно в несколько строк).");
        System.out.println("Для завершения ввода введите пустую строку и нажмите Enter:");

        StringBuilder textBuilder = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            textBuilder.append(line).append(" ");
        }

        String text = textBuilder.toString().trim();
        scanner.close();

        if (text.isEmpty()) {
            System.out.println("Вы не ввели текст. Завершение работы.");
            return;
        }

        Map<String, Integer> frequency = new HashMap<>();

        // Приводим к нижнему регистру и разбиваем по всем не-буквенным символам
        String[] words = text.toLowerCase().split("[^a-z]+");

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        System.out.println("\nРазличные слова:");
        System.out.println(frequency.keySet());

        System.out.println("\nЧастота слов (по алфавиту):");
        frequency.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}