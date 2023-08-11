package org.example.Communication;

import org.example.Model.StudentGrades;
import org.example.Util.PasswordHashing;
import org.example.Util.Printer;
import org.example.Model.Role;
import org.example.Server.Database;
import org.example.View.*;
import java.io.*;
import java.util.*;

public class Response {
    static Database database = Database.getInstance();

    public void receive(DataInputStream input, DataOutputStream output, Role role) throws IOException, ClassNotFoundException {
            switch (role) {
                case ADMIN -> handleAdminOptions(input, output);
                case STUDENT -> handleStudentOptions(input, output);
                case INSTRUCTOR -> handleInstructorOptions(input, output);
                default -> throw new IllegalStateException("Unsupported role");
            }
    }

    private void handleAdminOptions(DataInputStream input, DataOutputStream output) throws IOException {
        AdminView adminView = new AdminView();
        output.writeUTF(adminView.getDisplayOptions());
        int option = input.readInt(); //read option selected by user
        String table = database.getDatabaseTable(option);
        String check = "";
        while(!check.equalsIgnoreCase("no")) {
            List<String> columns = database.getTableColumns(table);
            List<String[]> tableContent = database.getTableContent(table);
            String content = Printer.displayTableContent(columns, tableContent);
            output.writeUTF(content); //send table content
            output.writeUTF(database.getCrudOptions(table)); //send crud options
            int chosenCRUD = input.readInt(); //read crud option selected by user
            switch (chosenCRUD) {
                case 1 -> {
                    String userId;
                    while (true) {
                        output.writeUTF("Enter " + columns.get(0) + " (7-digit numeric ID): ");
                        userId = input.readUTF(); //read user's id from client
                        if (!userId.matches("\\d{7}")) {
                            output.writeBoolean(false);
                            output.writeUTF("Invalid ID format. ID must be a 7-digit numeric value.");
                            continue;
                        }
                        output.writeBoolean(true); //if id was exactly 7 (true)
                        boolean isUserExists = database.isUserIdExists(userId, table); //check if it exists or not (true:exists:re-enter id)
                        if (isUserExists) {
                            output.writeBoolean(false);
                            output.writeUTF("Error: " + columns.get(0) + " already exists. Please enter a different ID.");
                            continue;
                        }
                        output.writeBoolean(true);
                        break;
                    }
                    Map<String, String> inputData = new HashMap<>();
                    inputData.put(columns.get(0), userId); //add username
                    output.writeInt(columns.size()); //send field size to client
                    for (String fieldName : columns) {
                        if (!fieldName.equals(columns.get(0))) { //since it is already printed and entered
                            output.writeUTF("Enter " + fieldName + ": ");
                            String value = input.readUTF(); //read field value from user
                            inputData.put(fieldName, value);
                        }
                    }
                    output.writeUTF(table); //send table name to user
                    if (!Objects.equals(table, "courses")) {
                        output.writeUTF("Enter user's password: ");
                        String userPassword = input.readUTF(); //read user's password and hash it
                        String hashedPassword = PasswordHashing.hashPassword(userPassword);
                        inputData.put("password", hashedPassword);
                        System.out.println();
                    }
                    boolean isAdded = database.addRecord(table, inputData); //execute the add record
                    if (isAdded) {
                        output.writeUTF("Record added successfully");
                    } else {
                        output.writeUTF("Record wasn't added an error occurred");
                    }
                }
                case 2 -> output.writeUTF(content);
                case 3 -> {
                    output.writeUTF("Select the column you want to update:");
                    output.writeInt(columns.size());
                    for (int i = 0; i < columns.size(); i++) {
                        output.writeUTF((i + 1) + ". " + columns.get(i));
                    }
                    int columnChoice = input.readInt();
                    String columnToUpdate = columns.get(columnChoice - 1);
                    String primaryKeyColumn = columns.get(0);
                    String idToUpdate, newValue;
                    while (true) {
                        output.writeUTF("Enter the ID of the record you want to update: ");
                        idToUpdate = input.readUTF();
                        boolean isIdExists = database.isUserIdExists(idToUpdate, table); //check if it exists or not (true:exists:re-enter id)
                        if (!isIdExists) {
                            output.writeBoolean(false);
                            output.writeUTF("Error: " + columns.get(0) + " ID doesn't exist. Please enter one of the displayed id's!");
                            continue;
                        }
                        output.writeBoolean(true);
                        break;
                    }
                    while (true) {
                        output.writeUTF("\nEnter the new value for " + columnToUpdate + ": ");
                        newValue = input.readUTF();
                        boolean isUserExists = database.isUserIdExists(newValue, table); //check if it exists or not (true:exists:re-enter id)
                        if (isUserExists) {
                            output.writeBoolean(false);
                            output.writeUTF("Error: " + columns.get(0) + " ID already exists. Please enter a different ID.");
                            continue;
                        }
                        output.writeBoolean(true);
                        break;
                    }
                    boolean isUpdated = database.updateRecord(table, columnToUpdate,
                            primaryKeyColumn, idToUpdate, newValue);
                    if (isUpdated) {
                        output.writeUTF("Successfully updated the record.");
                    } else {
                        output.writeUTF("No record was found with the specified ID.");
                    }
                }
                case 4 -> {
                    while (true) {
                        output.writeUTF("Enter the ID of the record you want to delete:");
                        String idToDelete = input.readUTF();
                        boolean isDeleted = database.deleteRecord(table, idToDelete);
                        if (!isDeleted) {
                            output.writeBoolean(false);
                            output.writeUTF("No record was found with the specified ID.");
                            continue;
                        }
                        output.writeBoolean(true);
                        break;
                    }
                    output.writeUTF("Successfully deleted the record.");
                }
                case 5 -> handleAdminOptions(input, output);
            }
            output.writeUTF("Do you wish to continue(yes/no): ");
            check = input.readUTF();
        }
        output.writeUTF("Thank you for your visit admin enjoy your day :)");
    }

    private void handleStudentOptions(DataInputStream input, DataOutputStream output) throws IOException {
        StudentView studentView = new StudentView();
        int studentId = input.readInt();
        String check = "";
        while (!check.equalsIgnoreCase("no")) {
            output.writeUTF(studentView.getDisplayOptions());
            int option = input.readInt(); //read option selected by user
            switch (option) {
                case 1 -> {
                    StudentGrades studentGrades = database.viewGrades(studentId);
                    String grades = Printer.displayStudentGradesInfo(studentGrades.getStudentId(), studentGrades.getStudentName(), studentGrades.getCourseGrades());
                    output.writeUTF(grades); //send view grades to user
                }
                case 2 -> {
                    Map<Integer, String> courseList = database.viewCourses(studentId, Role.STUDENT);
                    String courses = Printer.displayCourses(studentId, database.getDbUsername(Role.STUDENT, studentId), courseList);
                    output.writeUTF(courses);
                }
                case 3 -> {
                    while(true) {
                        Map<Integer, String> availableCourses = database.getAvailableCourses(studentId, Role.STUDENT);
                        String courses = Printer.displayAvailableCourses(availableCourses);
                        output.writeUTF(courses);
                        output.writeUTF("Enter the course ID to enroll/assign: ");
                        String courseId = input.readUTF();
                        boolean isEnrolled = database.enrollCourse(studentId, Role.STUDENT, "student_course", courseId);
                        if (!isEnrolled) {
                            output.writeBoolean(false);
                            output.writeUTF("Failed to enroll/assign the course. Make sure the course exists and you are eligible.");
                            continue;
                        }
                        output.writeBoolean(true);
                        output.writeUTF("Successfully enrolled in the course!");
                        break;
                    }
                }
            }
            output.writeUTF("Do you wish to continue(yes/no): ");
            check = input.readUTF(); //read check value if no stop
        }
        output.writeUTF("Thank you for your visit " + database.getDbUsername(Role.STUDENT, studentId) + " enjoy your day :)");
    }

    private void handleInstructorOptions(DataInputStream input, DataOutputStream output) throws IOException {
        InstructorView instructorView = new InstructorView();
        int instructorId = input.readInt();
        String check = "";
        while (!check.equalsIgnoreCase("NO")) {
            output.writeUTF(instructorView.getDisplayOptions());
            int option = input.readInt(); //read option selected by user
            switch (option) {
                case 1 -> {
                    Map<Integer, String> courseList = database.viewCourses(instructorId, Role.INSTRUCTOR);
                    String courses = Printer.displayCourses(instructorId, database.getDbUsername(Role.INSTRUCTOR, instructorId), courseList);
                    output.writeUTF(courses);
                }
                case 2, 3 -> {
                    String gradeOrUpdate = (option == 2  ? "grade" : "update");
                    int courseId;
                    while (true) {
                        Map<Integer, String> courseList = database.viewCourses(instructorId, Role.INSTRUCTOR);
                        String courses = Printer.displayCourses(instructorId, database.getDbUsername(Role.INSTRUCTOR, instructorId), courseList);
                        output.writeUTF(courses);
                        output.writeUTF("Enter the Course ID to " + gradeOrUpdate + ": ");
                        courseId = input.readInt();
                        if (!courseList.containsKey(courseId)) {
                            output.writeBoolean(false);
                            output.writeUTF("Invalid course ID. Please try again.");
                            continue;
                        }
                        output.writeBoolean(true);
                        break;
                    }
                    int studentId;
                    while(true) {
                        Map<Integer, String> students = (option == 2)
                                ? database.fetchStudentsWithGrades(courseId, false)
                                : database.fetchStudentsWithGrades(courseId, true);
                        String studentsToGrade = Printer.displayStudents(students);
                        if(studentsToGrade.equals("No students found")){
                            output.writeBoolean(false);
                            output.writeUTF("No students found");
                            return;
                        }
                        output.writeBoolean(true);
                        output.writeUTF(studentsToGrade);
                        output.writeUTF("Enter the Student ID to " + gradeOrUpdate + ": ");
                        studentId = input.readInt();
                        if(!students.containsKey(studentId)){
                            output.writeBoolean(false);
                            output.writeUTF("Enter student ID to " + gradeOrUpdate + ": ");
                            continue;
                        }
                        output.writeBoolean(true);
                        break;
                    }
                    output.writeUTF("Enter grade for the student: ");
                    float grade = input.readFloat();
                    boolean isStudentGradeAdded = database.addOrUpdateStudentGrade(courseId, studentId, grade, gradeOrUpdate);
                    if(!isStudentGradeAdded) {
                        output.writeBoolean(false);
                        output.writeUTF("Failed to perform operation on grade.");
                        continue;
                    }
                    output.writeBoolean(true);
                    output.writeUTF("Grade added successfully!");
                }
                case 4 -> {
                    int courseId;
                    while (true){
                        Map<Integer, String> courseList = database.viewCourses(instructorId, Role.INSTRUCTOR);
                        String courses = Printer.displayCourses(instructorId, database.getDbUsername(Role.INSTRUCTOR, instructorId), courseList);
                        output.writeUTF(courses);
                        output.writeUTF("Enter the course ID to view students and their grades:");
                        courseId = input.readInt();
                        if (!courseList.containsKey(courseId)) {
                            output.writeBoolean(false);
                            output.writeUTF("Invalid course ID. Please try again.");
                            continue;
                        }
                        output.writeBoolean(true);
                        break;
                    }
                    List<StudentGrades> studentGrades = database.getAllCourseStudents(courseId);
                    String grades = Printer.displayStudentsWithGrades(studentGrades);
                    output.writeUTF(grades);
                }
                case 5 -> {
                    while(true) {
                        Map<Integer, String> availableCourses = database.getAvailableCourses(instructorId, Role.INSTRUCTOR);
                        String courses = Printer.displayAvailableCourses(availableCourses);
                        output.writeUTF(courses);
                        output.writeUTF("Enter the course ID to enroll/assign: ");
                        String courseId = input.readUTF();
                        boolean isEnrolled = database.enrollCourse(instructorId, Role.INSTRUCTOR, "instructor_course", courseId);
                        if (!isEnrolled) {
                            output.writeBoolean(false);
                            output.writeUTF("Failed to enroll/assign the course. Make sure the course exists and you are eligible.");
                            continue;
                        }
                        output.writeBoolean(true);
                        output.writeUTF("Successfully enrolled in the course!");
                        break;
                    }
                }
            }
            output.writeUTF("Do you wish to continue(yes/no): ");
            check = input.readUTF();
        }
        output.writeUTF("Thank you for your visit " + database.getDbUsername(Role.INSTRUCTOR, instructorId) + " enjoy your day :)");
    }
}