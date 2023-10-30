package utils;

public class ValidationUtil {
    /*
     * Student code must be in format <S000>, 0 is a digit.
     * Student name can not be blank
     * Mark: 0..10
     */
    public static boolean isStudentCode(String code) {
        return code.matches("^S\\d{3}$");
    }

    public static boolean isStudentName(String name) {
        return !name.trim().isEmpty();
    }

    public static boolean isMark(double mark) {
        return mark >= 0 && mark <= 10;
    }
}
