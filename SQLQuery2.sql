-- Create database GradingManagement2
CREATE DATABASE GradingManagement2;
USE GradingManagement2;

-- Users Table
CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100),
    user_type VARCHAR(20)
);

-- Students Table
CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100),
    student_major VARCHAR(50),

);

-- Teachers Table
CREATE TABLE Teachers (
    teacher_id INT PRIMARY KEY,
    user_id INT UNIQUE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Courses Table
CREATE TABLE Courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100),
    semester VARCHAR(50),
    start_date DATE,
    end_date DATE
);

-- Enrollments Table
CREATE TABLE Enrollments (
    enrollment_id INT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

-- Grades Table
CREATE TABLE Grades (
    grade_id INT PRIMARY KEY,
    student_id INT,
    enrollment_id INT,
    assignment1 DECIMAL(3, 1),
    assignment2 DECIMAL(3, 1),
    progresstest1 DECIMAL(3, 1),
    progresstest2 DECIMAL(3, 1),
    totalgrade DECIMAL(3, 1),
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (enrollment_id) REFERENCES Enrollments(enrollment_id)
);
