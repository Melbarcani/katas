package com.example.katas.args;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {

    private List<String> args;

    public Command() {
        args = new ArrayList<>();
    }

    public int size() {
        return args.size();
    }

    public List<String> listArgs() {
        return args;
    }

    public void run(String args) {
        var argsList = args.split(" ");
        for (String arg : argsList) {
            if (arg.startsWith("-")) {
                 ArgFactory.create(arg.substring(1));
            }
        }
    }
}
