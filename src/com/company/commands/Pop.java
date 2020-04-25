package com.company.commands;

import com.company.CalcEnviroment;
import com.company.Command;

public class Pop implements Command {

    @Override
    public void do_operation(CalcEnviroment environment, String[] args) {
        if (args.length != 0)
            throw new IllegalArgumentException("Need arguments: <value>");
        environment.pop();
        environment.print("Poped.");
    }
}
