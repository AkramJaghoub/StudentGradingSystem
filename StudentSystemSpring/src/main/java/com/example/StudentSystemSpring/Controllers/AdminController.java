package com.example.StudentSystemSpring.Controllers;

import com.example.StudentSystemSpring.Data.DAO;
import com.example.StudentSystemSpring.Util.PasswordHashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    private final DAO dao;

    @Autowired
    public AdminController(DAO dao) {
        this.dao = dao;
    }

    @GetMapping("/crud")
    public String crud(@RequestParam("table") String table, Model model) {
        model.addAttribute("table", table);
        return "crud";
    }

    @GetMapping("/createRecord")
    public String displayCreateRecordForm(@RequestParam String table,
                              Model model) {
        model.addAttribute("table", table);
        model.addAttribute("headers", dao.getTableColumns(table));
        model.addAttribute("rowsData", dao.getTableContent(table));
        return "create_record";
    }

    @PostMapping("/createRecord")
    public String createRecord(@RequestParam String table,
                               @RequestParam(value = "user_id", required = false) String userId,
                               @RequestParam(value = "username", required = false) String username,
                               @RequestParam(value = "password", required = false) String password,
                               @RequestParam(value = "course_id", required = false) String courseId,
                               @RequestParam(value = "course_name", required = false) String courseName,
                               Model model) {
        Map<String, String> inputData = new HashMap<>();
        List<String> columns = dao.getTableColumns(table);
        model.addAttribute("table", table);

        if ("courses".equals(table)) {
            if (courseId == null || courseId.isEmpty() || courseName == null || courseName.isEmpty()) {
                model.addAttribute("errorMessage", "Course ID and Course Name must be provided.");
                return displayCreateRecordForm(table, model);
            }

            if (!courseId.matches("\\d{7}")) {
                model.addAttribute("errorMessage", "Invalid ID format. ID must be a 7-digit numeric value.");
                return displayCreateRecordForm(table, model);
            }
            if (dao.isIdExists(courseId, table)) {
                model.addAttribute("errorMessage", "Error: Course ID already exists. Please enter a different ID.");
                return displayCreateRecordForm(table, model);
            }

            inputData.put(columns.get(0), courseId);
            inputData.put("course_name", courseName);

        } else {
            if (userId == null || userId.isEmpty() || username == null || username.isEmpty() || password == null || password.isEmpty()) {
                model.addAttribute("errorMessage", "User ID, Username, and Password must be provided.");
                return displayCreateRecordForm(table, model);
            }

            if (!userId.matches("\\d{7}")) {
                model.addAttribute("errorMessage", "Invalid ID format. ID must be a 7-digit numeric value.");
                return displayCreateRecordForm(table, model);
            }
            if (dao.isIdExists(userId, table)) {
                model.addAttribute("errorMessage", "Error: ID already exists. Please enter a different ID.");
                return displayCreateRecordForm(table, model);
            }

            inputData.put(columns.get(0), userId);
            inputData.put("username", username);
            inputData.put("password", PasswordHashing.hashPassword(password));
        }

        boolean isAdded = dao.addRecord(table, inputData);
        if (isAdded) {
            model.addAttribute("successMessage", "Record added successfully");
        } else {
            model.addAttribute("errorMessage", "Record wasn't added; an error occurred");
        }
        return displayCreateRecordForm(table, model);
    }

    @GetMapping("/readRecords")
    public String readRecords(@RequestParam("table") String table, Model model) {
        List<String> headers = dao.getTableColumns(table);
        List<String[]> rowsData = dao.getTableContent(table);
        model.addAttribute("table", table);
        model.addAttribute("headers", headers);
        model.addAttribute("rowsData", rowsData);
        return "read_record";
    }

    @GetMapping("/updateRecord")
    public String updateRecord(@RequestParam("table") String table, Model model) {
        List<String> columns = dao.getTableColumns(table);
        List<String[]> rowsData = dao.getTableContent(table);
        model.addAttribute("table", table);
        model.addAttribute("headers", columns);
        model.addAttribute("rowsData", rowsData);
        model.addAttribute("column1", columns.get(0));
        model.addAttribute("column2", columns.get(1));
        return "update_record";
    }

    @PostMapping("/updateRecord")
    public String updateRecordPost(@RequestParam("table") String table,
                                   @RequestParam("columnChoice") int columnChoice,
                                   @RequestParam("idToUpdate") String idToUpdate,
                                   @RequestParam("newValue") String newValue,
                                   Model model) {
        List<String> columns = dao.getTableColumns(table);
        String columnToUpdate = columns.get(columnChoice - 1);
        String primaryKeyColumn = columns.get(0);
        if (!dao.isIdExists(idToUpdate, table)) {
            model.addAttribute("errorMessage", "Error: " + primaryKeyColumn + " ID doesn't exist. Please enter one of the displayed ids!");
        } else if (dao.isIdExists(newValue, table)) {
            model.addAttribute("errorMessage", "Error: " + primaryKeyColumn + " ID already exists. Please enter a different ID.");
        } else {
            boolean isUpdated = dao.updateRecord(table, columnToUpdate, primaryKeyColumn, idToUpdate, newValue);
            if (isUpdated) {
                model.addAttribute("successMessage", "Successfully updated the record.");
            } else {
                model.addAttribute("errorMessage", "You are trying to modify sensitive data!.");
            }
        }
        return updateRecord(table, model);
    }

    @GetMapping("/deleteRecord")
    public String deleteRecord(@RequestParam("table") String table, Model model) {
        List<String> headers = dao.getTableColumns(table);
        List<String[]> rowsData = dao.getTableContent(table);
        model.addAttribute("table", table);
        model.addAttribute("headers", headers);
        model.addAttribute("rowsData", rowsData);
        return "delete_record";
    }


    @PostMapping("/deleteRecord")
    public String deleteRecordPost(@RequestParam("table") String table,
                                   @RequestParam("idToDelete") String idToDelete,
                                   Model model) {
        boolean isDeleted = dao.deleteRecord(table, idToDelete);
        if (isDeleted) {
            model.addAttribute("successMessage", "Successfully deleted the record.");
        } else {
            model.addAttribute("errorMessage", "You are trying to delete sensitive information!\nmight be related to other tables!.");
        }
        return "delete_record";
    }
}