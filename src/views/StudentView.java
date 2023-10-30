package views;

import entities.Student;
import services.StudentServices;

import java.util.ArrayList;

import static utils.InputUtil.*;
import static utils.OutputUtil.*;

public class StudentView {
    private enum MENU_STUDENT {
        EXIT,
        ADD_NEW_STUDENT,
        SEARCH_STUDENT,
        UPDATE_NAME_AND_MARK_STUDENT,
        REMOVE_STUDENT,
        SHOW_ALL_STUDENT,
    }

    private final StudentServices serviceStudent = new StudentServices();

    public void studentView() {
        boolean exit = false;
        while (!exit) {
            printLineSeparate("Student Management");
            printValueMenu("Student");
            for (MENU_STUDENT menu : MENU_STUDENT.values()) {
                printValueMenu(menu.ordinal() + " to  " + menu.name().replace("_", " ").toLowerCase());
            }
            printLineSeparate();
            try {
                int choice = readInt("Enter your choice: ");
                if (choice < 0 || choice >= MENU_STUDENT.values().length) {
                    printValueln("Invalid choice.");
                } else {
                    switch (MENU_STUDENT.values()[choice]) {
                        case EXIT -> exit = true;
                        case ADD_NEW_STUDENT -> this.addNewStudent();
                        case SEARCH_STUDENT -> this.searchStudent();
                        case UPDATE_NAME_AND_MARK_STUDENT -> this.updateNameAndMarkStudent();
                        case REMOVE_STUDENT -> this.removeStudent();
                        case SHOW_ALL_STUDENT -> this.showAllStudent();
                        default -> {
                        }
                    }
                }
            } catch (Exception e) {
                printValueln(e.getMessage());
            }
        }
    }

    private void showAllStudent() {
        try {
            ArrayList<Student> students = serviceStudent.getAll();
            if (students.size() > 0) {
                printValueln("List of students:");
                for (Student student : students) {
                    printValueln(student.toString());
                }
            } else {
                printValueln("List of students is empty.");
            }
        } catch (Exception e) {
            printValueln(e.getMessage());
        }
    }

    private void removeStudent() {
        try {
            String code = readString("Enter code: ");
            Student student = serviceStudent.getByCode(code);
            if (student != null) {
                serviceStudent.delete(student);
                printValueln("Remove student successfully.");
            } else {
                printValueln("Student not found.");
            }
        } catch (Exception e) {
            printValueln(e.getMessage());
        }
    }

    private void addNewStudent() {
        try {
            String code = readString("Enter code: ");
            String name = readString("Enter name: ");
            double mark = readDouble("Enter mark: ");
            Student student = new Student(code, name, mark);
            serviceStudent.create(student);
            printValueln("Add new student successfully.");
        } catch (Exception e) {
            printValueln(e.getMessage());
        }
    }

    private void searchStudent() {
        try {
            String code = readString("Enter code: ");
            Student student = serviceStudent.getByCode(code);
            if (student != null) {
                printValueln(student.toString());
            } else {
                printValueln("Student not found.");
            }
        } catch (Exception e) {
            printValueln(e.getMessage());
        }
    }

    private void updateNameAndMarkStudent() {
        try {
            String code = readString("Enter code: ");
            Student student = serviceStudent.getByCode(code);
            if (student != null) {
                String name = readString("Enter name: ");
                double mark = readDouble("Enter mark: ");
                student.setName(name);
                student.setMark(mark);
                serviceStudent.update(student);
                printValueln("Update student successfully.");
            } else {
                printValueln("Student not found.");
            }
        } catch (Exception e) {
            printValueln(e.getMessage());
        }
    }
}
