package com.company;


// Исключение при попытке получения операции по имени.

public class OperationCreateException extends Exception {

    OperationCreateException(String operation) {
        super("Operation implementation " + operation + " not found.");
    }

    OperationCreateException(String message, Throwable e) {
        super(message, e);
    }
}