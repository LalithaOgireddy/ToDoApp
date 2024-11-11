package com.lalitha;

import com.lalitha.model.Person;
import com.lalitha.model.TodoItem;
import com.lalitha.model.TodoItemTask;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person person=new Person("Lalitha","Ogireddy","lalitha@hotmail.com");
        Person person2=new Person("Sayana","Surendran","Sayana@hotmail.com");

        TodoItem todoItem=new TodoItem("Cleaning Garage","declutter and oranize garage", LocalDate.of(2024,11,17),person);

        System.out.println( person.toString());
        System.out.println( todoItem.toString());

        todoItem.setDone(true);
        if(todoItem.isOverdue()){
            System.out.println("Task overdue");
        }else{
            System.out.println("Deadline is not over");
        }


        TodoItemTask task1= new TodoItemTask(todoItem,person);
        System.out.println(task1.toString());
        task1.setAssignee(person2);
        System.out.println(task1.toString());
    }
}