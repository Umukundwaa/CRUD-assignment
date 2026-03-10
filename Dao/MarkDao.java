package Dao;

import DBconnection;
import Model.Mark;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarksDAO {

    // ADD a mark
    public void addMark(Mark mark) {
        String sql = "INSERT INTO marks (student_id, course_id, marks) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, mark.getStudentId());
            stmt.setInt(2, mark.getCourseId());
            stmt.setDouble(3, mark.getMarks());
            stmt.executeUpdate();
            System.out.println("Mark added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding mark: " + e.getMessage());
        }
    }

    // GET all marks
    public List<Mark> getAllMarks() {
        List<Mark> marks = new ArrayList<>();
        String sql = "SELECT * FROM marks";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                marks.add(new Mark(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getDouble("marks")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching marks: " + e.getMessage());
        }
        return marks;
    }

    // GET one mark by student_id AND course_id
    public Mark getMarkByIds(int studentId, int courseId) {
        String sql = "SELECT * FROM marks WHERE student_id=? AND course_id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Mark(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getDouble("marks")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error finding mark: " + e.getMessage());
        }
        return null;
    }

    // UPDATE a mark
    public void updateMark(int studentId, int courseId, double marks) {
        String sql = "UPDATE marks SET marks=? WHERE student_id=? AND course_id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, marks);
            stmt.setInt(2, studentId);
            stmt.setInt(3, courseId);
            stmt.executeUpdate();
            System.out.println("Mark updated successfully!");

        } catch (SQLException e) {
            System.out.println("Error updating mark: " + e.getMessage());
        }
    }

    // DELETE a mark
    public void deleteMark(int studentId, int courseId) {
        String sql = "DELETE FROM marks WHERE student_id=? AND course_id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.executeUpdate();
            System.out.println("Mark deleted successfully!");

        } catch (SQLException e) {
            System.out.println("Error deleting mark: " + e.getMessage());
        }
    }
}
