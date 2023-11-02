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
import model.Courses;
import model.Teachers;

/**
 *
 * @author Mr.Khanh
 */
public class CoursesDBConnect extends DBConnect {

    public List<Courses> getAll() {
        List<Courses> list = new ArrayList<>();
        String sql = "SELECT C.[course_id],\n"
                + "       C.[subject_Code],\n"
                + "       C.[subject_name],\n"
                + "       C.[semester],\n"
                + "       C.[start_date],\n"
                + "       C.[end_date],\n"
                + "       C.[teacher_id],\n"
                + "       T.[teacher_name] -- Include teacher_name in the query\n"
                + "  FROM [dbo].[Courses] AS C\n"
                + "  JOIN [dbo].[Teachers] AS T ON C.[teacher_id] = T.[teacher_id];";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Courses c = new Courses();
                c.setCourse_id(rs.getInt("course_id"));
                c.setSubject_Code(rs.getString("subject_Code"));
                c.setSubject_name(rs.getString("subject_name"));
                c.setSemester(rs.getString("semester"));
                c.setStart_date(rs.getString("start_date"));
                c.setEnd_date(rs.getString("end_date"));

                Teachers t = new Teachers();
                t.setTeacher_name(rs.getString("teacher_name"));
                c.setTeachers(t);

                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
