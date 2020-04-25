package com.company.commands;

import com.company.CalcEnviroment;
import com.company.Command;


public class Sqrt implements Command {

    @Override
    public void do_operation(CalcEnviroment environment, String[] args) {
        double value = environment.pop();
        if (value < 0) {
            environment.push(value);
            throw new ArithmeticException("Square root from < 0 number.");
        }
        environment.push(Math.sqrt(value));
        environment.print("Square root taken.");
    }
}
