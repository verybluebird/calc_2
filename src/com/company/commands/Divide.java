package com.company.commands;

import com.company.CalcEnviroment;
import com.company.Command;
import com.company.IllegalStackException;

public class Divide implements Command {

    @Override
    public void do_operation(CalcEnviroment environment, String[] args) {
        if (environment.stackSize() < 2)
            throw new IllegalStackException(2, environment.stackSize());
        double right = environment.pop();
        if (right == 0) {
            environment.push(right);
            throw new ArithmeticException("Division by zero.");
        }
        double left = environment.pop();
        environment.push(left / right);
        environment.print("Divided.");
    }
}
