package com.lalitha.model;

import com.lalitha.util.IDGen;

import java.time.LocalDate;

public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    public TodoItem(String title, String taskDescription, LocalDate deadLine, Person creator) {
        this.id= IDGen.nextIdForTodoItem();
        this.setTitle(title);
        this.taskDescription = taskDescription;
        this.setDeadLine(deadLine);
        this.creator = creator;
        this.done=false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public boolean isOverdue(){
        return this.deadLine.isBefore(LocalDate.now());
    }
    public String getSummary(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id);
        sb.append(", Title: ").append(title);
        sb.append(", Task desc: ").append(taskDescription);
        sb.append(", Deadline: ").append(deadLine);
        return sb.toString();
    }
}
