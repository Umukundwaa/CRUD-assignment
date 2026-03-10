
import Dao.CourseDao;
import Dao.MarksDao;
import Dao.StudentDao;
import Model.Course;
import Model.Mark;
import Model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {

    static StudentDao studentDAO = new StudentDao();
    static CourseDao courseDAO = new CourseDao();
    static MarksDao marksDAO = new MarksDao();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choice = "";

        while (!choice.equals("0")) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Add Course");
            System.out.println("7. View All Courses");
            System.out.println("8. View Course by ID");
            System.out.println("9. Update Course");
            System.out.println("10. Delete Course");
            System.out.println("11. Add Mark");
            System.out.println("12. View All Marks");
            System.out.println("13. View Mark by Student & Course");
            System.out.println("14. Update Mark");
            System.out.println("15. Delete Mark");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addStudent();
                case "2" -> viewAllStudents();
                case "3" -> viewStudentById();
                case "4" -> updateStudent();
                case "5" -> deleteStudent();
                case "6" -> addCourse();
                case "7" -> viewAllCourses();
                case "8" -> viewCourseById();
                case "9" -> updateCourse();
                case "10" -> deleteCourse();
                case "11" -> addMark();
                case "12" -> viewAllMarks();
                case "13" -> viewMarkByIds();
                case "14" -> updateMark();
                case "15" -> deleteMark();
                case "0" -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // STUDENT METHODS
    static void addStudent() {
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        studentDAO.addStudent(new Student(0, firstName, lastName, email, dob));
    }

    static void viewAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    static void viewStudentById() {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student s = studentDAO.getStudentById(id);
        System.out.println(s != null ? s : "Student not found.");
    }

    static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("New first name: ");
        String firstName = scanner.nextLine();
        System.out.print("New last name: ");
        String lastName = scanner.nextLine();
        System.out.print("New email: ");
        String email = scanner.nextLine();
        System.out.print("New date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        studentDAO.updateStudent(new Student(id, firstName, lastName, email, dob));
    }

    static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        studentDAO.deleteStudent(id);
    }

    //  COURSE METHODS 
    static void addCourse() {
        System.out.print("Course name: ");
        String name = scanner.nextLine();
        System.out.print("Course description: ");
        String desc = scanner.nextLine();
        courseDAO.addCourse(new Course(0, name, desc));
    }

    static void viewAllCourses() {
        List<Course> courses = courseDAO.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            courses.forEach(System.out::println);
        }
    }

    static void viewCourseById() {
        System.out.print("Enter course ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Course c = courseDAO.getCourseById(id);
        System.out.println(c != null ? c : "Course not found.");
    }

    static void updateCourse() {
        System.out.print("Enter course ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("New course name: ");
        String name = scanner.nextLine();
        System.out.print("New course description: ");
        String desc = scanner.nextLine();
        courseDAO.updateCourse(new Course(id, name, desc));
    }

    static void deleteCourse() {
        System.out.print("Enter course ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        courseDAO.deleteCourse(id);
    }

    // MARKS METHODS 
    static void addMark() {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter mark: ");
        double marks = Double.parseDouble(scanner.nextLine());
        marksDAO.addMark(new Mark(studentId, courseId, marks));
    }

    static void viewAllMarks() {
        List<Mark> marks = marksDAO.getAllMarks();
        if (marks.isEmpty()) {
            System.out.println("No marks found.");
        } else {
            marks.forEach(System.out::println);
        }
    }

    static void viewMarkByIds() {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());
        Mark m = marksDAO.getMarkByIds(studentId, courseId);
        System.out.println(m != null ? m : "Mark not found.");
    }

    static void updateMark() {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new mark: ");
        double marks = Double.parseDouble(scanner.nextLine());
        marksDAO.updateMark(studentId, courseId, marks);
    }

    static void deleteMark() {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());
        marksDAO.deleteMark(studentId, courseId);
    }
}
