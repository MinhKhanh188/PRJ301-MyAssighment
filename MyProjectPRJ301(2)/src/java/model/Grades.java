/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mr.Khanh
 */
public class Grades {

    private int grade_id;
    private int student_id;
    private int enrollment_id;
    private double assignment1;
    private double assignment2;
    private double progresstest1;
    private double progresstest2;
    private double FE;
    private double totalgrade;
    private Students students;
    private Enrollments enrollments;

    public Grades() {
    }

    public Grades(int grade_id, int student_id, int enrollment_id, double assignment1,
            double assignment2, double progresstest1, double progresstest2, double FE, double totalgrade) {
        this.grade_id = grade_id;
        this.student_id = student_id;
        this.enrollment_id = enrollment_id;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.progresstest1 = progresstest1;
        this.progresstest2 = progresstest2;
        this.FE = FE;
        this.totalgrade = totalgrade;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(int enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    public double getAssignment1() {
        return assignment1;
    }

    public void setAssignment1(double assignment1) {
        this.assignment1 = assignment1;
    }

    public double getAssignment2() {
        return assignment2;
    }

    public void setAssignment2(double assignment2) {
        this.assignment2 = assignment2;
    }

    public double getProgresstest1() {
        return progresstest1;
    }

    public void setProgresstest1(double progresstest1) {
        this.progresstest1 = progresstest1;
    }

    public double getProgresstest2() {
        return progresstest2;
    }

    public void setProgresstest2(double progresstest2) {
        this.progresstest2 = progresstest2;
    }

    public double getFE() {
        return FE;
    }

    public void setFE(double FE) {
        this.FE = FE;
    }

    public double getTotalgrade() {
        return totalgrade;
    }

    public void setTotalgrade(double totalgrade) {
        this.totalgrade = totalgrade;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Enrollments getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Enrollments enrollments) {
        this.enrollments = enrollments;
    }

}
