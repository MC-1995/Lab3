import java.util.*;

public class Task3Sets {
    public static void main(String[] args) {
        List<Human> people = Arrays.asList(
                new Human("Иван", "Иванов", 30),
                new Human("Пётр", "Петров", 25),
                new Human("Анна", "Сидорова", 28),
                new Human("Иван", "Иванов", 30), // дубликат
                new Human("Мария", "Кузнецова", 35),
                new Human("Алексей", "Смирнов", 25)
        );

        System.out.println("Исходный список:");
        people.forEach(System.out::println);

        System.out.println("\nHashSet:");
        Set<Human> hashSet = new HashSet<>(people);
        hashSet.forEach(System.out::println);

        System.out.println("\nLinkedHashSet:");
        Set<Human> linkedHashSet = new LinkedHashSet<>(people);
        linkedHashSet.forEach(System.out::println);

        System.out.println("\nTreeSet, естественный порядок:");
        Set<Human> treeSet = new TreeSet<>(people);
        treeSet.forEach(System.out::println);

        System.out.println("\nTreeSet с компаратором по фамилии:");
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(people);
        treeSetByLastName.forEach(System.out::println);

        System.out.println("\nTreeSet с анонимным компаратором по возрасту:");
        Set<Human> treeSetByAge = new TreeSet<>(Comparator.comparingInt(Human::getAge));
        treeSetByAge.addAll(people);
        treeSetByAge.forEach(System.out::println);

        /*
         * Различия:
         * 1. HashSet не гарантирует порядок хранения элементов и удаляет дубликаты
         *    по equals/hashCode.
         * 2. LinkedHashSet сохраняет порядок добавления и также удаляет дубликаты.
         * 3. TreeSet хранит элементы отсортированными. Для Human используется compareTo,
         *    поэтому порядок: возраст -> фамилия -> имя.
         * 4. TreeSet с HumanComparatorByLastName сортирует только по фамилии.
         *    Если у двух людей одинаковая фамилия, компаратор возвращает 0,
         *    и TreeSet считает их одинаковыми.
         * 5. TreeSet с анонимным компаратором по возрасту сортирует по возрасту.
         *    Люди с одинаковым возрастом считаются одинаковыми и не добавляются повторно.
         */
    }
}