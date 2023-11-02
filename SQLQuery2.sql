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
	enrollment_id int,
    grade_id int,
    status VARCHAR(100),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) ,
	FOREIGN KEY (enrollment_id) REFERENCES Enrollments(enrollment_id),
	FOREIGN KEY (grade_id) REFERENCES Grades(grade_id)-- Reference the course_id
);





select * from Courses

select * from Teachers

select * from Users

select * from Students

select * from Enrollments


INSERT INTO [dbo].[Students] ([student_id], [student_name])
VALUES (176285, N'Pham Minh Khanh');
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

	INSERT INTO [dbo].[Users]
           ([user_id]
           ,[username]
           ,[password]
           ,[user_type])
     VALUES
           (1,'admin','a',1),
		    (2,'sonnt','sonnhieutiendepzai',2);

INSERT INTO [dbo].[Teachers]
           ([teacher_id]
           ,[teacher_name]
           ,[user_id])
     VALUES
          (1, 'Ngo Tung Son', 2);


INSERT INTO [dbo].[Courses]
           ([course_id]
           ,[subject_Code]
           ,[subject_name]
           ,[semester]
           ,[start_date]
           ,[end_date]
           ,[teacher_id])
     VALUES
           (6617,'PRJ301','Java Web Application Development', 'Fall23','2023-09-01','2023-12-15',1),
		   (10173,'NWC203c','Computer Networking', 'Fall23','2023-09-15','2023-12-24',1),
		   (9228,'JPD123','Computer Networking', 'Fall23','2023-09-15','2023-12-24',1),
		   (10021,'LAB211','OOP with Java Lab', 'Fall23','2023-09-10','2023-12-24',1),
		   (3674,'PRU211c','(Combo .Net: Option 3) C# Programming and Unity', 'Fall23','2023-09-10','2023-12-24',1),
		   (9241,'MAD101','Discrete mathematics', 'Fall23','2023-09-03','2023-12-24',1),
		   (10128,'PMG201c','Project Management', 'Fall23','2023-09-03','2023-12-24',1),
		   (6291,'JIT401','Information Technology Japanese', 'Fall23','2023-09-03','2023-12-24',1),
		   (10031,'IOT102','Internet of Things', 'Fall23','2023-11-01','2023-12-24',1),
		   (6021,'JPD133','Elementary Japanese 1-A1/A2', 'Fall23','2023-09-01','2023-12-24',1),
		   (10209,'PRN221','Advanced Cross-Platform Application Programming With .NET', 'Fall23','2023-09-01','2023-12-24',1),
		   (9226,'JPD113','Elementary Japanese 1-A1.2', 'Fall23','2023-09-05','2023-12-15',1),
		   (10005,'HCM202','HCM Ideology', 'Fall23','2023-09-05','2023-12-15',1);