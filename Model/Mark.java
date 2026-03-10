package Model;

public class Mark {
    private int studentId; 
    private int courseId; 
    private double marks;  


    public Mark(int studentId, int courseId, double marks) {
        this.studentId = studentId;
        this.courseId=courseId ;
        this.marks = marks;

    }


    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }



    @Override
    public String toString() {
        return "Mark{studentId=" + studentId + ", courseId=" + courseId + ", marks=" + marks + "}";
    }
}
