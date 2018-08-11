package task2_ExtendedDatabase;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final int CAPACITY = 16;

    private List<Person> people;

    public Database(Person... inputPeople) throws OperationNotSupportedException {
        this.people = new ArrayList<>(CAPACITY);

        setPeople(inputPeople);
    }

    public void add(Person person) throws OperationNotSupportedException {
        if (this.people.stream().filter(p -> p.getId().equals(person.getId())).count() >= 1) {
            throw new OperationNotSupportedException("Person already exists!");
        }

        if (isInvalid(person)) {
            throw new OperationNotSupportedException("Invalid name or ID!");
        }

        if (this.people.size() == CAPACITY) {
            throw new OperationNotSupportedException("Array is full!");
        }

        this.people.add(person);
    }

    public Person remove() throws OperationNotSupportedException {
        if (this.people.size() == 0) {
            throw new OperationNotSupportedException("Array is empty!");
        }

        return this.people.remove(this.people.size() - 1);
    }

    public Person findByUsername(String username) throws OperationNotSupportedException {
        if (username == null) {
            throw new OperationNotSupportedException("Invalid Person!");
        }

        if (this.people.stream().noneMatch(p -> p.getName().equals(username))) {
            throw new OperationNotSupportedException("No such Person!");
        }

        return this.people.stream().filter(p -> p.getName().equals(username)).findFirst().get();
    }

    public Person findById(Integer id) throws OperationNotSupportedException {
        if (id == null) {
            throw new OperationNotSupportedException("Invalid Id!");
        }

        if (this.people.stream().noneMatch(p -> p.getId().equals(id))) {
            throw new OperationNotSupportedException("No such Id!");
        }

        return this.people.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }

    public List<Person> fetch() {
        return this.people;
    }

    public void setPeople(Person... people) throws OperationNotSupportedException {
        for (int i = 0; i < people.length; i++) {
            if (i == CAPACITY) {
                throw new OperationNotSupportedException("Array is full!");
            }

            if (!isInvalid(people[i])) {
                this.people.add(people[i]);
            }
        }
    }

    private boolean isInvalid(Person person) {
        if (person.getId() < 0 || person.getId() == null) {
            return true;
        }

        return false;
    }
}
