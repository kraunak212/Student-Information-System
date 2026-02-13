package ValidationUtils;

public class ValidationUtils {

    // ------ Method To Check Valid Age ------

    public static boolean CheckValidAge(int age) {
        if (age >= 0) {
            return true;
        }
        return false;
    }

    // ------ Method To Check Valid Grade ------

    public static boolean CheckGrade(double grade)
    {
        if (grade >= 0 && grade <= 100) {
            return true;
        }
        return false;
    }


}
