package com.lalitha;

import com.lalitha.data.dao.People;
import com.lalitha.data.dao.TodoItems;
import com.lalitha.data.dao.impl.PeopleImpl;
import com.lalitha.data.dao.impl.TodoItemsImpl;
import com.lalitha.db.MYSQLConnection;
import com.lalitha.model.Person;
import com.lalitha.model.Todo;

import java.sql.Connection;


public class Main {
    public static void main(String[] args) {

        Connection connection= MYSQLConnection.getConnection();

        People people=new PeopleImpl(connection);
        /*Person person=new Person("Fredrik","Svensson");
        Person person=new Person("Sayana","Surendran");
        Person person=new Person("Mathews","Svensson");*/
        Person person=new Person("Anna","Svensson");
        people.create(person);
        System.out.println(people.findById(2));
        System.out.println(people.findByName("Mathews"));
        System.out.println(people.findAll());
        Person person1=people.findById(3);
        person.setLastName("Johnsson");
        System.out.println(people.update(person1));
        people.deleteById(4);
        System.out.println(people.findAll());



        TodoItems todoItem=new TodoItemsImpl(connection);
        //Todo todo=new Todo("Change tires","Need to change tires", LocalDate.of(2025,1,9),false,2);
       // Todo todo=new Todo("Cooking","Need to cook Lunch", LocalDate.of(2025,1,11),false);
       // Todo todo=new Todo("Groceries","Need to buy groceries", LocalDate.of(2025,1,5),false,2);
       // Todo todo=new Todo("Complete Homework","Finish Science exercises", LocalDate.of(2025,1,5),false);
       // Todo todo=new Todo("Meeting","Discussion about courses", LocalDate.of(2025,2,3),false,1);
        //todoItem.create(todo);



        System.out.println(todoItem.findAll());
        System.out.println("====================================");
        System.out.println(todoItem.findByAssignee(people.findById(1)));
        System.out.println("====================================");
           System.out.println(todoItem.findByAssignee(2));
        System.out.println("====================================");
        Todo todo=todoItem.findById(1);
        todo.setDone(true);
        todoItem.update(todo);
        System.out.println("<====================================>");
        System.out.println(todoItem.findByDoneStatus(false));
        System.out.println("====================================");
        System.out.println(todoItem.findByUnassignedTodoItems());
        todoItem.deleteById(4);

        System.out.println("====================================");




    }
}