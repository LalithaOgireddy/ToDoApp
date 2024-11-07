package com.lalitha.model;

import com.lalitha.util.IDGen;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(TodoItem todoItem, Person assignee) {
        this.id= IDGen.nextIdForTodoItemTask();
        this.todoItem = todoItem;
        this.setAssignee(assignee);

    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    public String getSummary(){
        StringBuilder sb=new StringBuilder();
        sb.append("{ id: ").append(id);
        sb.append(" , assigned: ").append(assigned);
        sb.append(" , todoItem: ").append(todoItem.getSummary());
        sb.append(" , assignee: ").append(assignee != null ? assignee.getFirstName()+" "+assignee.getLastname():"Null");
        sb.append("}");
        return sb.toString();
    }
}
