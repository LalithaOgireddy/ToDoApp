package com.lalitha.data.dao;

import com.lalitha.model.TodoItem;
import com.lalitha.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO{
    private Collection<TodoItemTask> todoItemTasks;
    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        TodoItemTask newTodoItemTask = new TodoItemTask(todoItemTask.getTodoItem(),todoItemTask.getAssignee());
        todoItemTasks.add(newTodoItemTask);
        return newTodoItemTask;
    }

    @Override
    public TodoItemTask findById(int id) {
        for(TodoItemTask task : todoItemTasks){
            if(task.getId() == id) return task;
        }
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return Collections.unmodifiableCollection(todoItemTasks);
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        Collection<TodoItemTask> assignedList = new ArrayList<>();
        for(TodoItemTask task : todoItemTasks){
            if(task.isAssigned() == status) assignedList.add(task);
        }
        return assignedList;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        Collection<TodoItemTask> personList = new ArrayList<>();
        for(TodoItemTask task : todoItemTasks){
            if(task.getId() == personId) personList.add(task);
        }
        return personList;
    }

    @Override
    public void remove(int id) {
        for(TodoItemTask task : todoItemTasks){
            if(task.getId() == id) {
                todoItemTasks.remove(task);
            }
        }
    }
}
