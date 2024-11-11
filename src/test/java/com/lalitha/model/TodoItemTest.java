package com.lalitha.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTest {

    private Person person;
    private TodoItem todoItem;
    private TodoItem overdueItem;

    @BeforeEach
    void setUp() {
        person=new Person("Lalitha","Ogireddy","lalitha@gmail.com");
        todoItem=new TodoItem("Meal prep","Have to meal prep for next week", LocalDate.of(2024,11,11),person);
    }


    @Test
    void testConstructTodoItem(){
        assertEquals("Meal prep",todoItem.getTitle());
        assertEquals("Have to meal prep for next week",todoItem.getTaskDescription());
        assertEquals(LocalDate.of(2024,11,11),todoItem.getDeadLine());
        assertFalse(todoItem.isDone());
        assertEquals(person,todoItem.getCreator());
    }

    @Test
    void testSetDone() {
        assertFalse(todoItem.isDone());
        todoItem.setDone(true);
        assertTrue(todoItem.isDone());

    }

    @Test
    void testIsOverdue() {
        overdueItem=new TodoItem("Meal prep","Have to meal prep for next week",LocalDate.of(2024,10,9),person);
        assertTrue(overdueItem.isOverdue());
        assertFalse(todoItem.isOverdue());
    }
}