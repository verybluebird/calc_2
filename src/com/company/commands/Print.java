package com.company.commands;

import com.company.CalcEnviroment;
import com.company.Command;


// Печать верхнего элемента стека.

public class Print implements Command {

    @Override
    public void do_operation(CalcEnviroment environment, String[] args) {
        environment.print("Value: " + environment.peek());
    }
}