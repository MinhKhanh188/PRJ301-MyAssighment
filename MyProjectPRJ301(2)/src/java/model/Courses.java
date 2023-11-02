/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mr.Khanh
 */
public class Courses {

    private int course_id;
    private String subject_Code;
    private String subject_name;
    private String semester;
    private String start_date;
    private String end_date;
    private int teacher_id;
    private Teachers teachers;

    public Courses() {
    }

    public Courses(int course_id, String subject_Code, String subject_name, String semester, String start_date, String end_date, int teacher_id) {
        this.course_id = course_id;
        this.subject_Code = subject_Code;
        this.subject_name = subject_name;
        this.semester = semester;
        this.start_date = start_date;
        this.end_date = end_date;
        this.teacher_id = teacher_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getSubject_Code() {
        return subject_Code;
    }

    public void setSubject_Code(String subject_Code) {
        this.subject_Code = subject_Code;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }

}
