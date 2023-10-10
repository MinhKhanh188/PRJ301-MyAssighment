Create database GradingManagement 

-- Users Table: Stores user accounts with authentication information and user type.
CREATE TABLE Users (
    user_id INT PRIMARY KEY,     -- Unique identifier for each user.
    username VARCHAR(50) UNIQUE,  -- Unique username for login.
    password VARCHAR(100),       -- Securely hashed password.
    user_type VARCHAR(20) -- 'Student' or 'Teacher' -- Indicates the role of the user.
);

-- Students Table: Stores information about students and links to user accounts.
CREATE TABLE Students (
    student_id INT PRIMARY KEY,  -- Unique identifier for each student.
    user_id INT UNIQUE,          -- Foreign Key referencing Users(user_id).
);

-- Teachers Table: Stores information about teachers and links to user accounts.
CREATE TABLE Teachers (
    teacher_id INT PRIMARY KEY,  -- Unique identifier for each teacher.
    user_id INT UNIQUE,          -- Foreign Key referencing Users(user_id).
);

-- Courses Table: Stores information about courses, including semester and duration.
CREATE TABLE Courses (
    course_id INT PRIMARY KEY,   -- Unique identifier for each course.
    course_name VARCHAR(100),    -- Name of the course.
    semester VARCHAR(50),        -- Semester in which the course is offered.
    start_date  VARCHAR(50),     -- Start date of the course (you might consider using DATE data type).
    end_date  VARCHAR(50),       -- End date of the course (you might consider using DATE data type).
);

-- Enrollments Table: Tracks student enrollments in courses.
CREATE TABLE Enrollments (
    enrollment_id INT PRIMARY KEY,  -- Unique identifier for each enrollment.
    student_id INT,                 -- Foreign Key referencing Students(student_id).
    course_id INT,                  -- Foreign Key referencing Courses(course_id).
    enrollment_date DATE,           -- Date when the student enrolled in the course.
    FOREIGN KEY (student_id) REFERENCES Students(student_id),  -- Establishes student relationship.
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)     -- Establishes course relationship.
);

-- Grades Table: Stores student grades for assignments and tests.
CREATE TABLE Grades (
    grade_id INT PRIMARY KEY,       -- Unique identifier for each grade.
    student_id INT,                 -- Foreign Key referencing Students(student_id).
    enrollment_id INT,              -- Foreign Key referencing Enrollments(enrollment_id).
    assignment1 DECIMAL(3, 1),     -- Grade for assignment 1.
    assignment2 DECIMAL(3, 1),     -- Grade for assignment 2.
    progresstest1 DECIMAL(3, 1),   -- Grade for progress test 1.
    progresstest2 DECIMAL(3, 1),   -- Grade for progress test 2.
    totalgrade DECIMAL(3, 1),      -- Total grade (you can adjust precision and scale).
    FOREIGN KEY (student_id) REFERENCES Students(student_id),  -- Establishes student relationship.
    FOREIGN KEY (enrollment_id) REFERENCES Enrollments(enrollment_id)  -- Establishes enrollment relationship.
);
