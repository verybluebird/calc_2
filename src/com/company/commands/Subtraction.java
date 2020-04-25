package com.company.commands;

import com.company.CalcEnviroment;
import com.company.Command;
import com.company.IllegalStackException;

public class Subtraction implements Command {

    @Override
    public void do_operation(CalcEnviroment environment, String[] args) {
        if (environment.stackSize() < 2)
            throw new IllegalStackException(2, environment.stackSize());
        double right = environment.pop();

        double left = environment.pop();
        environment.push(left - right);
        environment.print("Substructed.");
    }
}
