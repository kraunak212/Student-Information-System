package StudentManager;
import Student.Student;

import java.util.ArrayList;
import java.util.Scanner;


public class StudentManager
{
    static ArrayList<Student> students = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    // ------Method To check Duplication Of Student ID------
    public static boolean checkdeplicateid( String id)
    {
        for(Student student : students)
        {
            if(student.getstudentID().equalsIgnoreCase(id))
            {
                return true;
            }

        }
        return false;

    }


    // ------Add Student------

    public static void addStudent() {
        sc.nextLine();

        System.out.println("\n=== ADD NEW STUDENT ===");

        System.out.print("Enter Student ID: ");
        String studentID = sc.nextLine();

        // ------ Duplication Method call to check student ID ------

        if(checkdeplicateid(studentID))
        {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Student Grade: ");
        double grade = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Student Contact: ");
        String contact = sc.nextLine();


        Student student = new Student(name, age, grade, studentID, contact);
        students.add(student);

        System.out.println("Student Added Successfully!");
    }

    // ------ View Student ------

    public static void viewAllStudents()
    {
        System.out.println("\n=== ALL STUDENTS ===");
        if(students.isEmpty())
        {
            System.out.println("There are no students in the system!");
            return;
        }
        for(Student student : students)
        {
            System.out.printf("\n%-15s %-20s %-8s %-8s %-15s\n",
                    "Student ID", "Name", "Age", "Grade", "Contact");
            System.out.println("-".repeat(70));

            System.out.printf("%-15s %-20s %-8d %-8.2f %-15s\n",
                    student.getstudentID(), student.getName(),
                    student.getage(), student.getGrade(), student.getcontact());
        }
    }

    // ------ Search Student ------

    public static void  searchStudent()
    {
        sc.nextLine();

        System.out.println("Enter Student ID: ");
        String studentID = sc.nextLine();

        for( Student student : students) {
            if (student.getstudentID().equalsIgnoreCase(studentID)){
                System.out.println("Student Found Successfully!");
                System.out.println("student ID: " + student.getstudentID());
                System.out.println("student Name: " + student.getName());
                System.out.println("student Age: " + student.getage());
                System.out.println("student Grade: " + student.getGrade());
                System.out.println("student Contact: " + student.getcontact());
                return;
            }
        }
        System.out.println("Student ID Not Found!");
        return;
    }

    // ------ Update Student ------

    public static void updateStudent() {
        sc.nextLine(); // clear buffer

        System.out.print("Enter Student ID to update: ");
        String studentID = sc.nextLine();

        for (Student student : students) {

            if (student.getstudentID().equalsIgnoreCase(studentID)) {

                System.out.println("Student Found!");

                // Update Name
                System.out.print("Do you want to update Name? (yes/no): ");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    System.out.print("Enter new name: ");
                    student.setName(sc.nextLine());
                }

                // Update Age
                System.out.print("Do you want to update Age? (yes/no): ");
                choice = sc.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    System.out.print("Enter new age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // consume newline
                    student.setAge(age);
                }

                // Update Grade
                System.out.print("Do you want to update Grade? (yes/no): ");
                choice = sc.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    System.out.print("Enter new grade: ");
                    double grade = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    student.setGrade(grade);
                }

                // Update Contact
                System.out.print("Do you want to update Contact? (yes/no): ");
                choice = sc.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    System.out.print("Enter new contact: ");
                    student.setContact(sc.nextLine());
                }

                System.out.println("Student details updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }
}
