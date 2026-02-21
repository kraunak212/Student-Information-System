package GradeManage_ReportGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import GradeManage_StudentGrade.StudentGrade;
import GradeManage_GradeCal.GradeCalculator;

public class ReportGenerator {

    public static void findTopPerformers(StudentGrade[] students, int count) {

        if(count == 0) {
            System.out.println("No students found!");
            return;
        }

        int topperIndex = 0;
        double highest = students[0].calculateAverage();

        for(int i = 1; i < count; i++) {
            double avg = students[i].calculateAverage();
            if(avg > highest) {
                highest = avg;
                topperIndex = i;
            }
        }

        System.out.println("\n=== TOP PERFORMER ===");
        System.out.printf("%s with Average = %.2f, Grade = %s\n",
                students[topperIndex].getStudentName(),
                highest,
                GradeCalculator.getGrade(highest));
    }

    public static void saveToFile(StudentGrade[] students, int count) {

        try {
            FileWriter writer = new FileWriter("students_runtime_example");

            for(int i = 0; i < count; i++) {
                writer.write(students[i].getStudentName());

                double[] marks = students[i].getMarks();
                for(double m : marks) {
                    writer.write("," + m);
                }
                writer.write("\n");
            }

            writer.close();
            System.out.println("Data saved to students_runtime_example.txt file");

        } catch(IOException e) {
            System.out.println("Error saving file!");
        }
    }

    public static int loadFromFile(StudentGrade[] students) {

        int count = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            String line;

            while((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                StudentGrade s = new StudentGrade(parts[0]);

                for(int i = 1; i <= 5 && i < parts.length; i++) {
                    try {
                        s.setMark(i-1, Double.parseDouble(parts[i]));
                    } catch(Exception e) {
                        s.setMark(i-1, 0);
                    }
                }

                students[count++] = s;
            }

            reader.close();
            System.out.println("Data loaded successfully!");

        } catch(IOException e) {
            System.out.println("No previous data found.");
        }

        return count;
    }

    public static void generateReport(StudentGrade[] students, int count) {

        if(count == 0) {
            System.out.println("No students found!");
            return;
        }

        double total = 0;

        for(int i = 0; i < count; i++) {
            total += students[i].calculateAverage();
        }

        double classAverage = total / count;

        System.out.println("\n=== CLASS REPORT ===");
        System.out.println("Total Students: " + count);
        System.out.printf("Class Average: %.2f\n", classAverage);

        findTopPerformers(students, count);
    }
}