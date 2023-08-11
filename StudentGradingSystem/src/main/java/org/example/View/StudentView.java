package org.example.View;

public class StudentView extends View {
    @Override
    public String getDisplayOptions() {
        return "Please choose one of the following options:\n" +
        "1. View Grades\t\t2. View Courses\t\t 3. enroll in course";
    }

    @Override
    public void displayErrorMessage(String error){
        System.err.println(error);
    }

    @Override
    public void displayEndingMessage(String message) {
        System.out.println(message);
    }
}
