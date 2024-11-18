package com.lalitha.data.dao;

import com.lalitha.model.AppUser;
import com.lalitha.model.Person;
import com.lalitha.model.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TodoItemDAOCollection implements TodoItemDAO{

    private Collection<TodoItem> todoItems;
    @Override
    public TodoItem persist(TodoItem todoItem) {
        TodoItem newTodoItem = new TodoItem(todoItem.getTitle(),todoItem.getTaskDescription(),todoItem.getDeadLine(),todoItem.getCreator());
        todoItems.add(newTodoItem);
        return newTodoItem;
    }

    @Override
    public TodoItem findById(int id) {
        for(TodoItem item : todoItems){
            if(item.getId() == id) return item;
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return Collections.unmodifiableCollection(todoItems);
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        Collection<TodoItem> doneList = new ArrayList<>();
        for(TodoItem item : todoItems){
            if(item.isDone()) doneList.add(item);
        }
        return doneList;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        Collection<TodoItem> titleList = new ArrayList<>();
        for(TodoItem item : todoItems){
            if(item.getTitle().trim().equals(title.trim())) titleList.add(item);
        }
        return titleList;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        Collection<TodoItem> personList = new ArrayList<>();
        for(TodoItem item : todoItems){
            if(item.getId() == personId) personList.add(item);
        }
        return personList;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        Collection<TodoItem> dlBeforeList = new ArrayList<>();
        for(TodoItem item : todoItems){
            if(!item.isOverdue()) dlBeforeList.add(item);
        }
        return dlBeforeList;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        Collection<TodoItem> dlAfterList = new ArrayList<>();
        for(TodoItem item : todoItems){
            if(item.isOverdue()) dlAfterList.add(item);
        }
        return dlAfterList;
    }

    @Override
    public void remove(int id) {
        for(TodoItem item : todoItems){
            if(item.getId() == id) {
                todoItems.remove(item);
            }
        }
    }
}
