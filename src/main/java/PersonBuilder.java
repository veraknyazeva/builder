import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    public PersonBuilder() {

    }

    public PersonBuilder(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        boolean hasAge = this.age.isPresent();

        if (surname == null) {
            throw new IllegalStateException("Вы не указали фамилию");
        }

        if (name == null) {
            throw new IllegalStateException("Вы не указали имя");
        }

        if (hasAge) {
            Person person = new Person(name, surname, age.getAsInt());
            person.setAddress(address);
            return person;
        } else {
            Person person = new Person(name, surname);
            person.setAddress(address);
            return person;
        }
    }
}
