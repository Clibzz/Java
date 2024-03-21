package com.nhlstenden.windturbines;

public class OverloadException extends  Exception {
    public OverloadException() {
        super("The system has overloaded!");
    }
}