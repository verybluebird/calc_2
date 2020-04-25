package com.company;

public class IllegalStackException extends IllegalStateException {

    /**
     * @param expected Ожидаемый размер стека.
     * @param actual   Реальный размер стека.
     */
    public IllegalStackException(int expected, int actual) {
        super("Expected minimum stack size is: " + expected + ". Actual is: " + actual);
    }

}