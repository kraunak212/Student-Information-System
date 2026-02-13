package StudentInformationSystem;
import StudentManager.StudentManager;
import java.util.Scanner;

import static StudentManager.StudentManager.*;

public class Main {
    public static void main(String[] args)
    {
        int choice;
        // Menu driven interface
        do {
            System.out.println("\n=== STUDENT INFORMATION SYSTEM ===");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4 :
                    updateStudent();
                    break;
                case 5: // Exit
                    System.out.println("Thank you for using Student Information System!");
                    break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        }
        while( choice != 5);
        sc.close();
    }


}
