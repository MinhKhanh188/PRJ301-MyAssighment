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
import model.Students;

/**
 *
 * @author Mr.Khanh
 */
public class StudentDBConnect extends DBConnect {

    public List<Students> getAll() {
        List<Students> list = new ArrayList<>();
        String sql = "SELECT [student_id]\n"
                + "      ,[student_name]\n"
                + "  FROM [dbo].[Students]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Students s = new Students();
                s.setStudent_id(rs.getInt("student_id"));
                s.setStudent_name(rs.getString("student_name"));
                list.add(s);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertStudent(Students model) {
        try {
            connection.setAutoCommit(false);
            String sql_insert = "INSERT INTO [dbo].[Students]\n"
                    + "           ([student_id]\n"
                    + "           ,[student_name])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            PreparedStatement stm_insert = connection.prepareStatement(sql_insert);
            stm_insert.setInt(1, model.getStudent_id());
            stm_insert.setString(2, model.getStudent_name());

            stm_insert.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(StudentDBConnect.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(StudentDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        StudentDBConnect dbConnect = new StudentDBConnect();
        List<Students> studentsList = dbConnect.getAll();

        // Print the list of students
        for (Students student : studentsList) {
            System.out.println("Student ID: " + student.getStudent_id());
            System.out.println("Student Name: " + student.getStudent_name());
        }
    }
}
