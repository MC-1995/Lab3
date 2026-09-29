import java.util.Objects;

public class Human implements Comparable<Human> {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human other) {
        int byAge = Integer.compare(this.age, other.age);
        if (byAge != 0) {
            return byAge;
        }

        int byLastName = this.lastName.compareTo(other.lastName);
        if (byLastName != 0) {
            return byLastName;
        }

        return this.firstName.compareTo(other.firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return age == human.age
                && Objects.equals(firstName, human.firstName)
                && Objects.equals(lastName, human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", возраст: " + age;
    }
}