/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
                    + "           ,[student_id]\n"
                    + "           ,[course_id]\n"
                    + "           ,[enrollment_date])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "		  , ?\n"
                    + "		  , ?\n"
                    + "		  , ?)";
            PreparedStatement stm_insert = connection.prepareStatement(sql_insert);
            stm_insert.setInt(1, model.getEnrollment_id());
            stm_insert.setInt(2, model.getStudent_id());
            stm_insert.setInt(3, model.getCourse_id());
            stm_insert.setString(4, model.getEnrollment_date());

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

}
