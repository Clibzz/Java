package com.nhlstenden.highCourt;

public class CouldNotClearWritException extends Exception {
    public CouldNotClearWritException() {
        super("The debt can not fully be paid");
    }
}
