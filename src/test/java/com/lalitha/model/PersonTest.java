package com.lalitha.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() {
        person=new Person("Lalitha","Ogireddy","lalitha@hotmail.com");
    }


    @Test
    void testConstructPerson(){
        assertEquals("Lalitha",person.getFirstName());
        assertEquals("Ogireddy",person.getLastName());
        assertEquals("lalitha@hotmail.com",person.getEmail());
    }

    @Test
    void testGettersSetters(){
        person.setFirstName("Dinesh");
        person.setLastName("Reddy");
        person.setEmail("dinesh@gmail.com");
        assertEquals("Dinesh",person.getFirstName());
        assertEquals("Reddy",person.getLastName());
        assertEquals("dinesh@gmail.com",person.getEmail());
    }



    @Test
    void testNullFirstName(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Person(null,"Abhiram","abhi@yahoo.com");
        });
    }
}