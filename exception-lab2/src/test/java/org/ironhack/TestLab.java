package org.ironhack;

import org.ironhack.tasks.Person;
import org.ironhack.tasks.PersonList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLab {
    private Person person;
    private PersonList personList;
    private Person person2;

    @BeforeEach
    public void setUp()
    {  person=new Person(1,"Mansura Badalova",19,"rest");
        person2=new Person(3,"Leyla Alasgarli",20,"rest");
        personList=new PersonList();
        personList.add(person);
        personList.add(person2);
    }

    @Test
    void checking_setAge(){
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-6));
    }

    @Test
    void testing_findByName_formattedName(){
        assertThrows(IllegalArgumentException.class, () ->personList.findByName("Mansura") );
    }

    @Test
    void testing_findByName_success() {
        Person found = personList.findByName("Mansura Badalova");
        assertEquals(person, found);
    }

    @Test
    void testing_clone(){
        Person cloned = personList.clone(person,2);
        assertEquals(person.getAge(),cloned.getAge());
        assertEquals(person.getName(),cloned.getName());
        assertEquals(person.getOccupation(),cloned.getOccupation());
        assertNotEquals(person.getId(),cloned.getId());
    }


}
