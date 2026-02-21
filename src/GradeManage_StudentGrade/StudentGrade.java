package GradeManage_StudentGrade;

public class StudentGrade {

    private String studentName;
    private double[] marks;
    private static final int SUBJECT_COUNT = 5;

    public StudentGrade(String studentName) {
        this.studentName = studentName;
        this.marks = new double[SUBJECT_COUNT];
    }

    public void setMark(int index, double mark) {
        marks[index] = mark;
    }

    public String getStudentName() {
        return studentName;
    }

    public double[] getMarks() {
        return marks;
    }

    public double calculateAverage() {
        double sum = 0;
        for(double m : marks) {
            sum += m;
        }
        return sum / SUBJECT_COUNT;
    }
}