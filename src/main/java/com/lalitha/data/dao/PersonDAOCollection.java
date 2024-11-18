package com.lalitha.data.dao;

import com.lalitha.model.AppUser;
import com.lalitha.model.Person;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PersonDAOCollection implements PersonDAO{

    Collection<Person> persons;

    @Override
    public Person persist(Person person) {
        Person newPerson = new AppUser(person.getFirstName(), person.getLastName(), person.getEmail());
        persons.add(newPerson);
        return newPerson;
    }

    @Override
    public Person findById(int id) {
        for(Person p : persons){
            if(p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for(Person p : persons){
            if(p.getEmail().trim().equals(email.trim())) return p;
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return Collections.unmodifiableCollection(persons);
    }

    @Override
    public void remove(int id) {
        for(Person p :persons){
            if(p.getId() == id) persons.remove(p);
        }
    }
}
