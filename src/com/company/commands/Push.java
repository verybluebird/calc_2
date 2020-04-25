package com.company.commands;

import com.company.CalcEnviroment;
import com.company.Command;

public class Push implements Command {

    @Override
    public void do_operation(CalcEnviroment environment, String[] args) {
        if (args.length != 1)
            throw new IllegalArgumentException("Need arguments: <value>");
        double value;
        try {
            value = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            value = environment.getDefinedValue(args[0]);
        }
        environment.push(value);
        environment.print("Pushed " + value);
    }
}
