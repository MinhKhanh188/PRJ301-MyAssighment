/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
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

    public List<Students> getAllStudents() {
        List<Students> studentsList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM [dbo].[Students]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Students student = new Students();
                student.setStudent_id(resultSet.getInt("student_id"));
                student.setStudent_name(resultSet.getString("student_name"));
                student.setStudent_major(resultSet.getString("student_major"));
                student.setStudent_gender(resultSet.getString("student_gender"));
                student.setStudent_dob(resultSet.getString("student_dob"));

                studentsList.add(student);
            }
        } catch (SQLException ex) {
            // Handle any exceptions here or log them as needed
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return studentsList;
    }
    
    
    public void insertStudent(Students model) {
        try {
            connection.setAutoCommit(false);
            String sql_insert = "INSERT INTO [dbo].[Students]\n"
                    + "           ([student_id]\n"
                    + "           ,[student_name]\n"
                    + "           ,[student_major]\n"
                    + "           ,[student_gender]\n"
                    + "           ,[student_dob])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm_insert = connection.prepareStatement(sql_insert);
            stm_insert.setInt(1, model.getStudent_id());
            stm_insert.setString(2, model.getStudent_name());
            stm_insert.setString(3, model.getStudent_major());
            stm_insert.setString(4, model.getStudent_gender());
            stm_insert.setString(5, model.getStudent_dob());

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
}
