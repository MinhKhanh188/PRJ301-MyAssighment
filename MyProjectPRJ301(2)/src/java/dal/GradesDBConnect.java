/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Grades;

/**
 *
 * @author Mr.Khanh
 */
public class GradesDBConnect extends DBConnect {

    public void GradesInsert(Grades model) {
        try {
            connection.setAutoCommit(false);
            String sql_insert = "INSERT INTO Grades (student_id, enrollment_id, assignment1, assignment2, progresstest1, progresstest2, FE, totalgrade) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement stm_insert = connection.prepareStatement(sql_insert);
            stm_insert.setInt(1, model.getStudent_id());
            stm_insert.setInt(2, model.getEnrollment_id());
            stm_insert.setDouble(3, model.getAssignment1());
            stm_insert.setDouble(4, model.getAssignment2());
            stm_insert.setDouble(5, model.getProgresstest1());
            stm_insert.setDouble(6, model.getProgresstest2());
            stm_insert.setDouble(7, model.getFE());
            stm_insert.setDouble(8, model.getTotalgrade());
            stm_insert.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(GradesDBConnect.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(GradesDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(GradesDBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(GradesDBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
