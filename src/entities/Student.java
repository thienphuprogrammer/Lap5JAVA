package entities;

public class Student {
    /*
     * Each student has a unique code.
     */
    // ------------------- PROPERTIES -------------------
    private String code;
    private String name;
    private double mark;

    //------------------ CONSTRUCTORS ------------------
    public Student(String code, String name, double mark) {
        this.code = code;
        this.name = name;
        this.mark = mark;
    }

    public Student() {
    }

    //------------------ GETTERS & SETTERS ------------------

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    //------------------ METHODS ------------------
    @Override
    public String toString() {
        return String.format("%-10s%-20s%-10.2f", code, name, mark);
    }
}
