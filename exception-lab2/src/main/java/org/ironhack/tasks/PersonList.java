package org.ironhack.tasks;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> persons;

    public PersonList() {
        this.persons = new ArrayList<>();
    }
    public void add(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) {
        if (name == null || !name.matches("\\w+ \\w+")) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }

        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getName().equals(name)) {
                return persons.get(i);
            }
        }
        throw new IllegalArgumentException("No such person");

    }

    public Person clone(Person person ,int newId) {
        return new Person(newId, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writingToFile(Person person) throws IOException {
        try (FileWriter file = new FileWriter("persons.txt", true)) {
            file.write(person.toString());

        }
        catch (IOException e) {
            System.out.println("Error writing to file");
        }

    }

}
