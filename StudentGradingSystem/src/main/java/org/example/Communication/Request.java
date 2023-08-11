package org.example.Communication;

import org.example.Model.Role;
import org.example.View.*;
import java.io.*;
import java.util.Scanner;

public class Request {
    AdminView adminView = new AdminView();
    private final Scanner inputScanner = new Scanner(System.in);
    public void send(DataInputStream input, DataOutputStream output, int id, Role role) throws IOException, ClassNotFoundException {
        switch (role) {
            case ADMIN -> handleAdminOptions(input, output);
            case STUDENT -> handleStudentOption(input, output, id);
            case INSTRUCTOR -> handleInstructorOption(input, output, id);
            default -> throw new IllegalStateException("Unsupported role");
        }
    }

    private void handleAdminOptions(DataInputStream input, DataOutputStream output) throws IOException {
        System.out.println(input.readUTF()); //display options
        int option = adminView.getOptionValue(1, 3);
        output.writeInt(option); //send option selected by user
        String check = "";
        while(!check.equalsIgnoreCase("no")) {
            System.out.println(input.readUTF()); //read table content
            System.out.println(input.readUTF()); //read crud options
            int crudOption = adminView.getOptionValue(1, 5);
            chosenCrud(input, output, crudOption);
            System.out.println(input.readUTF());//print do you wish to continue..
            check = inputScanner.next();
            output.writeUTF(check); //send entered value if no stop
        }
        adminView.displayEndingMessage(input.readUTF()); //thank for your visit admin
    }

    private void chosenCrud(DataInputStream input, DataOutputStream output, int crudOption) throws IOException {
        output.writeInt(crudOption); //send crud option selected by user
        switch (crudOption) {
            case 1 -> {
                while (true) {
                    System.out.println(input.readUTF()); // Read input message (7-digit number)
                    String id = adminView.readUserId();
                    output.writeUTF(id); // Send entered user's id to server
                    if (!input.readBoolean()) { //check if id is equal to 7
                        adminView.displayErrorMessage(input.readUTF());
                        continue;
                    }
                    boolean checkUserExistCondition = input.readBoolean();
                    if (!checkUserExistCondition) {
                        adminView.displayErrorMessage(input.readUTF());
                        continue;
                    }
                    break;
                }
                int fieldSize = input.readInt();
                for (int i = 1; i < fieldSize; i++) {
                    System.out.println(input.readUTF()); // Read fieldName print message
                    output.writeUTF(inputScanner.next()); // Send value
                }
                if(!input.readUTF().equals("courses")) {
                    System.out.println(input.readUTF()); // Enter password message
                    String userPassword = inputScanner.next();
                    output.writeUTF(userPassword); // Send user
                }
                System.out.println(input.readUTF()); // Record added successfully
            }
            case 2 -> System.out.println(input.readUTF()); //get table content
            case 3 -> {
                System.out.println(input.readUTF()); //read select the column message
                int columnSize = input.readInt(); //read column size
                for (int i = 0; i < columnSize; i++) {
                    System.out.println(input.readUTF()); //read columns
                }
                int columnChoice = adminView.getOptionValue(1, 2);
                output.writeInt(columnChoice); //send chosen column
                String idToUpdate;
                while(true) {
                    System.out.println(input.readUTF()); //read enter the id message
                    idToUpdate = inputScanner.next();
                    output.writeUTF(idToUpdate); //send chosen id
                    boolean isIdExistCondition = input.readBoolean();
                    if (!isIdExistCondition) {
                        adminView.displayErrorMessage(input.readUTF());
                        continue;
                    }
                    break;
                }
                while(true){
                    System.out.println(input.readUTF()); //read new value message
                    String newValue = inputScanner.next();
                    output.writeUTF(newValue);
                    boolean isUserExistCondition = input.readBoolean();
                    if (!isUserExistCondition) {
                        adminView.displayErrorMessage(input.readUTF());
                        continue;
                    }
                    break;
                }
                System.out.println(input.readUTF()); //update status
            }
            case 4 -> {
                while (true) {
                    System.out.println(input.readUTF()); //enter id of the record message
                    String idToDelete = inputScanner.next();
                    output.writeUTF(idToDelete);
                    boolean isDeleted = input.readBoolean();
                    if(!isDeleted){
                        adminView.displayErrorMessage(input.readUTF());
                        continue;
                    }
                    break;
                }
                System.out.println(input.readUTF()); //successfully deleted message
            }
            case 5 -> handleAdminOptions(input, output);
        }
    }
    private void handleStudentOption(DataInputStream input, DataOutputStream output, int id) throws IOException {
        StudentView studentView = new StudentView();
        output.writeInt(id);
        String check = "";
        while(!check.equalsIgnoreCase("no")){
            System.out.println(input.readUTF()); //read display options
            int option = studentView.getOptionValue(1, 3);
            output.writeInt(option); //send option selected by user to server
            switch (option) {
                case 1 -> System.out.println(input.readUTF()); //read view grades
                case 2 -> System.out.println(input.readUTF()); //read courses taken
                case 3 -> {
                    while (true){
                        System.out.println(input.readUTF()); //get available courses
                        System.out.println(input.readUTF()); //enter course id message
                        String courseId = inputScanner.next();
                        output.writeUTF(courseId);
                        boolean isEnrolled = input.readBoolean();
                        if(!isEnrolled){
                            studentView.displayErrorMessage(input.readUTF());
                            continue;
                        }
                        System.out.println(input.readUTF()); //read successfully enrolled message
                        break;
                    }
                }
            }
            System.out.println(input.readUTF()); //do you wish to continue..
            check = inputScanner.next();
            output.writeUTF(check); //send entered value if no stop
        }
        studentView.displayEndingMessage(input.readUTF()); //thank you for your visit...
    }

    private void handleInstructorOption(DataInputStream input, DataOutputStream output, int id) throws IOException {
        InstructorView instructorView = new InstructorView();
        output.writeInt(id);
        String check = "";
        while(!check.equalsIgnoreCase("no")){
            System.out.println(input.readUTF()); //read display options
            int option = instructorView.getOptionValue(1, 5);
            output.writeInt(option); //send option selected by user
            switch (option) {
                case 1 -> System.out.println(input.readUTF()); //read courses taken
                case 2, 3 -> {
                    while (true) {
                        System.out.println(input.readUTF()); //read courses taken
                        System.out.println(input.readUTF()); //enter courseId message
                        int courseId = inputScanner.nextInt();
                        output.writeInt(courseId);
                        boolean isCourseIdExists = input.readBoolean();
                        if (!isCourseIdExists) {
                            instructorView.displayErrorMessage(input.readUTF());
                            continue;
                        }
                        break;
                    }
                    while (true) {
                        boolean anyStudentExist = input.readBoolean();
                        if (!anyStudentExist) {
                            instructorView.displayErrorMessage(input.readUTF());
                            return;
                        }
                        System.out.println(input.readUTF()); //read students
                        System.out.println(input.readUTF()); //enter studentId message
                        int studentId = inputScanner.nextInt();
                        output.writeInt(studentId);
                        boolean isStudentIdExists = input.readBoolean();
                        if (!isStudentIdExists) {
                            instructorView.displayErrorMessage(input.readUTF());
                            continue;
                        }
                        break;
                    }
                    System.out.println(input.readUTF()); //read enter grade message
                    float grade = inputScanner.nextFloat();
                    output.writeFloat(grade);
                    boolean isStudentGradeAdded = input.readBoolean();
                    if (!isStudentGradeAdded) {
                        instructorView.displayErrorMessage(input.readUTF());
                        continue;
                    }
                    System.out.println(input.readUTF()); //grade added successfully
                }
                case 4 -> {
                    while (true) {
                        System.out.println(input.readUTF()); //read courses
                        System.out.println(input.readUTF()); //read enter course id to view grades... message
                        int courseId = inputScanner.nextInt();
                        output.writeInt(courseId);
                        boolean isCourseIdExists = input.readBoolean();
                        if (!isCourseIdExists) {
                            instructorView.displayErrorMessage(input.readUTF());
                            continue;
                        }
                        break;
                    }
                    System.out.println(input.readUTF()); //read grades
                }
                case 5 -> {
                    while (true) {
                        System.out.println(input.readUTF()); //get available courses
                        System.out.println(input.readUTF()); //enter course id message
                        String courseId = inputScanner.next();
                        output.writeUTF(courseId);
                        boolean isEnrolled = input.readBoolean();
                        if (!isEnrolled) {
                            instructorView.displayErrorMessage(input.readUTF());
                            continue;
                        }
                        System.out.println(input.readUTF()); //read successfully enrolled message
                        break;
                    }
                }
            }
            System.out.println(input.readUTF()); //do you wish to continue..
            check = inputScanner.next();
            output.writeUTF(check); //send entered value if no stop
        }
        instructorView.displayEndingMessage(input.readUTF()); //thank you for your visit instructor
    }
}
