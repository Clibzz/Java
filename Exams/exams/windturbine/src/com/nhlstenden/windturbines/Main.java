package com.nhlstenden.windturbines;

import com.nhlstenden.smartdisplay.dto.Displayable;
import com.nhlstenden.smartdisplay.main.SmartDisplay;

public class Main
{
    public static void main(String[] args)
    {
        SmartDisplay smartDisplay = new SmartDisplay();
        smartDisplay.setRunButtonAction(value -> {
            smartDisplay.showError("The system has overloaded!");
            // You can get the value of the text field (after pressing Run) by value.getValue();
            // This code block will run when you press the Run button.
        });
    }
}