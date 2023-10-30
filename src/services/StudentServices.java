package services;

import entities.Student;
import static utils.ValidationUtil.*;
import java.util.ArrayList;
import java.util.Objects;

public class StudentServices {
    ArrayList<Student> students = new ArrayList<>();
    public StudentServices() {
        // The List has at least 5 students. The first student is your information.
        students.add(new Student("S001", "Nguyen Van A", 9)); // The first student is your information.
        students.add(new Student("S002", "Nguyen Van B", 8));
        students.add(new Student("S003", "Nguyen Van C", 7));
        students.add(new Student("S004", "Nguyen Van D", 6));
        students.add(new Student("S005", "Nguyen Van E", 5));

    }
    public void create(Student student) {
        // Check Each student has a unique code. If not, throw an exception.
        // Check Student code must be in format <S000>, 0 is a digit. If not, throw an exception.
        // Check Student name can not be blank. If not, throw an exception.
        // Check Mark: 0..10. If not, throw an exception.
        // If all above conditions are satisfied, add new student to list.
        if (!isStudentCode(student.getCode())) {
            throw new IllegalArgumentException("Student code must be in format <S000>, 0 is a digit.");
        }
        if (!isStudentName(student.getName())) {
            throw new IllegalArgumentException("Student name can not be blank.");
        }
        if (!isMark(student.getMark())) {
            throw new IllegalArgumentException("Mark: 0..10.");
        }
        if (getByCode(student.getCode()) != null) {
            throw new IllegalArgumentException("Student code has already existed.");
        }
        students.add(student);
    }

    public Student getByCode(String code) {
        // Check if student code is valid. If not, throw an exception.
        // If student code is valid, return student.
        if (!isStudentCode(code)) {
            throw new IllegalArgumentException("Student code must be in format <S000>, 0 is a digit.");
        }
        for (Student student : students) {
            if (Objects.equals(student.getCode(), code)) {
                return student;
            }
        }
        return null;
    }

    public void update(Student student) {
        // Check if student code is valid. If not, throw an exception.
        // Check if student name is valid. If not, throw an exception.
        // Check if mark is valid. If not, throw an exception.
        // If all above conditions are satisfied, update student.
        if (!isStudentCode(student.getCode())) {
            throw new IllegalArgumentException("Student code must be in format <S000>, 0 is a digit.");
        }
        if (!isStudentName(student.getName())) {
            throw new IllegalArgumentException("Student name can not be blank.");
        }
        if (!isMark(student.getMark())) {
            throw new IllegalArgumentException("Mark: 0..10.");
        }
        for (Student student1 : students) {
            if (Objects.equals(student1.getCode(), student.getCode())) {
                student1.setName(student.getName());
                student1.setMark(student.getMark());
            }
        }
    }

    public void delete(Student student) {
        // Check if student code is valid. If not, throw an exception.
        // If student code is valid, remove student.
        if (!isStudentCode(student.getCode())) {
            throw new IllegalArgumentException("Student code must be in format <S000>, 0 is a digit.");
        }
        students.remove(student);
    }

    public ArrayList<Student> getAll() {
        // Return list of students.
        return students;
    }
}
