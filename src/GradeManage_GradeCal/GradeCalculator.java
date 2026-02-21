package GradeManage_GradeCal;

import java.util.Scanner;

public class GradeCalculator {

    public static String getGrade(double average) {
        if(average >= 90) return "A+";
        else if(average >= 80) return "A";
        else if(average >= 70) return "B";
        else if(average >= 60) return "C";
        else if(average >= 50) return "D";
        else return "F";
    }

    public static int getValidInt(Scanner scanner, int min, int max) {

        int value;

        while(true) {
            try {
                value = scanner.nextInt();
                scanner.nextLine();

                if(value >= min && value <= max)
                    return value;
                else
                    System.out.printf("Please enter a number between %d and %d: ", min, max);

            } catch(Exception e) {
                System.out.print("Invalid input! Please enter a number: ");
                scanner.nextLine();
            }
        }
    }

    public static double getValidMark(Scanner scanner) {

        double mark;

        while(true) {
            try {
                mark = scanner.nextDouble();
                scanner.nextLine();

                if(mark >= 0 && mark <= 100)
                    return mark;
                else
                    System.out.print("Marks must be between 0 and 100. Please re-enter: ");

            } catch(Exception e) {
                System.out.print("Invalid input! Please enter a number: ");
                scanner.nextLine();
            }
        }
    }
}