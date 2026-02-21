package GradeManage_main;

import java.util.Scanner;
import GradeManage_StudentGrade.StudentGrade;
import GradeManage_GradeCal.GradeCalculator;
import GradeManage_ReportGenerator.ReportGenerator;

public class Main {

    private static StudentGrade[] students;
    private static final int MAX_STUDENTS = 100;
    private static int studentCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        students = new StudentGrade[MAX_STUDENTS];
        studentCount = ReportGenerator.loadFromFile(students);

        students = new StudentGrade[MAX_STUDENTS];
        boolean running = true;

        while(running) {
            System.out.println("\n=== GRADE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student Marks");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Averages");
            System.out.println("4. Find Top Performers");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = GradeCalculator.getValidInt(scanner, 1, 6);

            switch(choice) {
                case 1:
                    addStudentMarks();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    calculateAverages();
                    break;
                case 4:
                    ReportGenerator.findTopPerformers(students, studentCount);
                    break;
                case 5:
                    ReportGenerator.generateReport(students, studentCount);
                    break;
                case 6:
                    ReportGenerator.saveToFile(students, studentCount);
                    running = false;
                    System.out.println("Thank you for using Grade Management System!");
                    break;
            }
        }
        scanner.close();
    }

    private static void addStudentMarks() {

        if(studentCount >= MAX_STUDENTS) {
            System.out.println("Maximum student limit reached!");
            return;
        }

        System.out.println("\n=== ADD STUDENT MARKS ===");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        StudentGrade student = new StudentGrade(name);

        String[] subjects = {"Mathematics", "Science", "English", "History", "Computer"};

        System.out.println("\nEnter marks for 5 subjects (out of 100):");

        for(int i = 0; i < 5; i++) {
            System.out.print(subjects[i] + ": ");
            double mark = GradeCalculator.getValidMark(scanner);
            student.setMark(i, mark);
        }

        students[studentCount++] = student;
        System.out.println("Student marks added successfully!");
    }

    private static void viewAllStudents() {

        System.out.println("\n=== ALL STUDENTS ===");

        if(studentCount == 0) {
            System.out.println("No students found!");
            return;
        }

        System.out.printf("%-20s %-12s %-12s %-12s %-12s %-12s %-12s\n",
                "Student Name", "Math", "Science", "English", "History", "Computer", "Average");

        System.out.println("-".repeat(100));

        for(int i = 0; i < studentCount; i++) {
            StudentGrade s = students[i];
            double avg = s.calculateAverage();
            double[] m = s.getMarks();

            System.out.printf("%-20s %-12.2f %-12.2f %-12.2f %-12.2f %-12.2f %-12.2f\n",
                    s.getStudentName(), m[0], m[1], m[2], m[3], m[4], avg);
        }
    }

    private static void calculateAverages() {

        System.out.println("\n=== STUDENT AVERAGES ===");

        for(int i = 0; i < studentCount; i++) {
            StudentGrade s = students[i];
            double avg = s.calculateAverage();
            String grade = GradeCalculator.getGrade(avg);

            System.out.printf("%-20s: Average = %.2f, Grade = %s\n",
                    s.getStudentName(), avg, grade);
        }
    }
}