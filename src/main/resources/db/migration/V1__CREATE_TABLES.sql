CREATE TABLE IF NOT EXISTS faculties (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    faculty_code VARCHAR(4) NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS student_groups (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    admission_year SMALLINT NOT NULL,
    after_highschool BOOLEAN NOT NULL,
    num INT NOT NULL,
    faculty_id BIGINT NOT NULL,
    FOREIGN KEY (faculty_id)
        REFERENCES faculties (id)
);

CREATE TABLE IF NOT EXISTS students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255),
    group_id BIGINT NOT NULL,
    FOREIGN KEY (group_id)
        REFERENCES student_groups (id)
);

CREATE TABLE IF NOT EXISTS plan_module (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS event_plan (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    module_id BIGINT NOT NULL,
    month SMALLINT NOT NULL,
    FOREIGN KEY (module_id)
        REFERENCES plan_module (id)
);
CREATE TABLE IF NOT EXISTS events (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    plan_id BIGINT NOT NULL,
    FOREIGN KEY (plan_id)
        REFERENCES event_plan (id)
);
CREATE TABLE IF NOT EXISTS event_participants (
    student_id BIGINT NOT NULL,
    event_id BIGINT NOT NULL,
    PRIMARY KEY (student_id , event_id),
    FOREIGN KEY (student_id)
        REFERENCES students (id),
    FOREIGN KEY (event_id)
        REFERENCES events (id)
);

CREATE TABLE IF NOT EXISTS courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS courses_participants (
    student_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    PRIMARY KEY (student_id , course_id),
    FOREIGN KEY (student_id)
        REFERENCES students (id),
    FOREIGN KEY (course_id)
        REFERENCES courses (id)
);

CREATE TABLE IF NOT EXISTS council_position (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS students_council (
    student_id BIGINT NOT NULL,
    position_id BIGINT NOT NULL,
    PRIMARY KEY (student_id , position_id),
    FOREIGN KEY (student_id)
        REFERENCES students (id),
    FOREIGN KEY (position_id)
        REFERENCES council_position (id)
);