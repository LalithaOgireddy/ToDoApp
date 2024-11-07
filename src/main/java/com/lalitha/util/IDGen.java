package com.lalitha.util;

public class IDGen {
    private static int personCounter = 0;
    private static int todoItemCounter = 100;
    private static int todoItemTaskCounter = 1000;
    public static int nextIdForPerson() {
        return ++personCounter;
    }

    public static int nextIdForTodoItem() {
        return ++todoItemCounter;
    }

    public static int nextIdForTodoItemTask() {
        return ++todoItemTaskCounter;
    }

}
