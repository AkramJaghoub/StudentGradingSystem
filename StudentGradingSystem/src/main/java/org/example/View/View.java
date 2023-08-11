package org.example.View;

import java.util.Scanner;

public abstract class View {

    protected Scanner input = new Scanner(System.in);
    public abstract String getDisplayOptions();

    public abstract void displayErrorMessage(String error);

    public abstract void displayEndingMessage(String message);

    public int getOptionValue(int min, int max) {
        int option;
        while (true) {
            option = input.nextInt();
            if (option >= min && option <= max) {
                break;
            }
            displayErrorMessage("Please enter a number from " + min + " to " + max + " only!!!");
        }
        return option;
    }
}
