package com.example.katas.args;

public class ArgFactory {
    public static Arg create(String arg){
        switch (arg){
            case "l" -> new BooleanArg("l");
        }
        return null;
    }
}
