-- Create database GradingManagement2
CREATE DATABASE GradingManagement3;
USE GradingManagement3;

-- Users Table
CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100),
    user_type INT
);

-- Students Table
CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100)
);

-- Teachers Table
CREATE TABLE Teachers (
    teacher_id INT PRIMARY KEY,
    teacher_name VARCHAR(100),
    user_id INT UNIQUE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Courses Table
CREATE TABLE Courses (
    course_id INT PRIMARY KEY,
    subject_Code VARCHAR(100),
    subject_name VARCHAR(1000),
    semester VARCHAR(50),
    start_date DATE,
    end_date DATE,
    teacher_id INT, -- Add a foreign key to link to the teacher
    FOREIGN KEY (teacher_id) REFERENCES Teachers(teacher_id)
);



-- Enrollments Table
CREATE TABLE Enrollments (
    enrollment_id INT PRIMARY KEY,
	class_id int,
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
    FE DECIMAL(3, 1),
    totalgrade DECIMAL(3, 1),
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (enrollment_id) REFERENCES Enrollments(enrollment_id)
);

-- TotalResult Table
CREATE TABLE TotalResult (
    TotalResult_id INT PRIMARY KEY,
    course_id INT,  -- Use course_id as the foreign key
    semester VARCHAR(50),
    start_date DATE,
    end_date DATE,
    totalgrade DECIMAL(3, 1),
    status VARCHAR(100),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)  -- Reference the course_id
);


-- Rename the column "subject_name" to "new_subject_name" in the "Courses" table
ALTER TABLE Courses RENAME COLUMN subject_name TO course_code;


select * from Courses

select * from Teachers

select * from Users

select * from Students

select * from Enrollments


INSERT INTO [dbo].[Students] ([student_id], [student_name])
VALUES (184524, 'Nguyen Huy Manh');
-- Generate and insert 10 random students with student_id between 152374 and 198945
INSERT INTO [dbo].[Students] ([student_id], [student_name])
VALUES
    (152374, N'Nguyen Van Anh'),
    (160789, N'Tran Thi Bich'),
    (168521, N'Le Duc Cong'),
    (176935, N'Pham Anh Danh'),
    (185249, N'Nguyen Van To Anh'),
    (161234, N'Tran Thi Fo'),
    (169648, N'Le Duc Giang'),
    (177962, N'Pham Anh Hung'),
    (186376, N'Nguyen Van Inh'),
    (194790, N'Tran Thi Joker');
