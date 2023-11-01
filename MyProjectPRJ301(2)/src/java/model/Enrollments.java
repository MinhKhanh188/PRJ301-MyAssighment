/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mr.Khanh
 */
public class Enrollments {

    private int enrollment_id;
    private int student_id;
    private int course_id;
    private String enrollment_date;
    private Students students;
    private Courses courses;

    public Enrollments() {
    }

    public Enrollments(int enrollment_id, int student_id, int course_id, String enrollment_date) {
        this.enrollment_id = enrollment_id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.enrollment_date = enrollment_date;
    }

    public int getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(int enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getEnrollment_date() {
        return enrollment_date;
    }

    public void setEnrollment_date(String enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

}
