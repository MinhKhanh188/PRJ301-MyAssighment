/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Courses;
import model.Enrollments;
import model.Students;

/**
 *
 * @author Mr.Khanh
 */
public class EnrollmentsDBConnect extends DBConnect {

    public List<Enrollments> getAll() {
        List<Enrollments> list = new ArrayList<>();
        String sql = "SELECT [enrollment_id]\n"
                + "      ,[class_id]\n"
                + "      ,[student_id]\n"
                + "      ,[course_id]\n"
                + "      ,[enrollment_date]\n"
                + "  FROM [dbo].[Enrollments]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Enrollments e = new Enrollments();
                e.setEnrollment_id(rs.getInt("enrollment_id"));
                e.setClass_id(rs.getInt("class_id"));

                Students s = new Students();
                s.setStudent_id(rs.getInt("student_id"));
                e.setStudents(s);

                Courses c = new Courses();
                c.setCourse_id(rs.getInt("course_id"));
                e.setCourses(c);

                e.setEnrollment_date(rs.getString("enrollment_date"));

                list.add(e);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void enrollmentInsert(Enrollments model) {
        try {
            connection.setAutoCommit(false);
            String sql_insert = "INSERT INTO [dbo].[Enrollments]\n"
                    + "           ([enrollment_id]\n"
                    + "           ,[class_id]\n"
                    + "           ,[student_id]\n"
                    + "           ,[course_id]\n"
                    + "           ,[enrollment_date])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?)";
            PreparedStatement stm_insert = connection.prepareStatement(sql_insert);
            stm_insert.setInt(1, model.getEnrollment_id());
            stm_insert.setInt(2, model.getClass_id());
            stm_insert.setInt(3, model.getStudent_id());
            stm_insert.setInt(4, model.getCourse_id());
            stm_insert.setString(5, model.getEnrollment_date());

            stm_insert.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(EnrollmentsDBConnect.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(EnrollmentsDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(EnrollmentsDBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(EnrollmentsDBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Students> getStudentsInClass(int classId) {
        List<Students> studentsInClass = new ArrayList<>();
        String sql = "SELECT DISTINCT S.[student_id], S.[student_name]\n"
                + "FROM [dbo].[Enrollments] AS E\n"
                + "JOIN [dbo].[Students] AS S ON E.[student_id] = S.[student_id]\n"
                + "WHERE E.[class_id] = ?";

        try ( PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, classId);
            try ( ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Students student = new Students();
                    student.setStudent_id(rs.getInt("student_id"));
                    student.setStudent_name(rs.getString("student_name"));
                    studentsInClass.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentsInClass;
    }

    public Set<Integer> getUniqueClassIds() {
        Set<Integer> uniqueClassIds = new HashSet<>();
        String sql = "SELECT DISTINCT [class_id] FROM [dbo].[Enrollments]";

        try ( PreparedStatement st = connection.prepareStatement(sql);  ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                uniqueClassIds.add(rs.getInt("class_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return uniqueClassIds;
    }

}
