package Student;
import ValidationUtils.ValidationUtils;

public class Student
{

    // ------ Private Data Members ------
    private String name;
    private int age;
    private double grade;
    private String studentID;
    private String contact;


    /*
         * Parameterized Constructor
        * Validation is applied for age and grade using setter methods.
    */
    public Student(String name, int age, double grade, String studentID, String contact) {
        this.name = name;
        setAge(age);
        setGrade(grade);
        this.studentID = studentID;
        this.contact = contact;


    }

// ------ Setter Methods ------

    // --- Setter For Name ---
    public void setName(String name)
    {
        this.name = name;
    }

    // ---Steer For Age ---
    public void setAge(int age) {
        if (ValidationUtils.CheckValidAge(age)) {
            this.age = age;
        } else {
            System.out.println("Invalid Age! Age must be positive.");
        }
    }

    // --- Setter For Grade ---
    public void setGrade(double grade)
    {
        if(ValidationUtils.CheckGrade(grade))
        {
            this.grade = grade;
        }
        else
        {
            System.out.println("Invalid Grade! Grade must be between 0 and 100");
        }

    }

    // --- Setter For Contact ---
    public void setContact(String contact)
    {
        this.contact = contact;
    }

    // ------ Getter Methods ------

    // --- Getter For Name ---
    public String getName()
    {
        return name;
    }

    // --- Getter For Age ---
    public int getage()
    {
        return age;
    }

    // --- Getter For Grade ---
    public double getGrade()
    {
        return grade;
    }

    // --- Getter For StudentID ---
    public String getstudentID()
    {
        return studentID;
    }

    // --- Getter For Contact ---
    public String getcontact()
    {
        return contact;
    }
}
