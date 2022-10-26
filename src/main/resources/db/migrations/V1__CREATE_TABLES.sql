CREATE TABLE specializations (
  id BIGINT AUTO_INCREMENT NOT NULL,
   title VARCHAR(255) NOT NULL,
   code VARCHAR(4) NULL,
   CONSTRAINT pk_specializations PRIMARY KEY (id)
);

CREATE TABLE `groups` (
  id BIGINT AUTO_INCREMENT NOT NULL,
   admission_year SMALLINT NOT NULL,
   after_high_school BIT(1) NOT NULL,
   specialization_id BIGINT NOT NULL,
   number INT NOT NULL,
   CONSTRAINT pk_groups PRIMARY KEY (id)
);

ALTER TABLE `groups` ADD CONSTRAINT FK_GROUPS_ON_SPECIALIZATION FOREIGN KEY (specialization_id) REFERENCES specializations (id);

CREATE TABLE students (
  id BIGINT AUTO_INCREMENT NOT NULL,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL,
   patronymic VARCHAR(255) NOT NULL,
   group_id BIGINT NOT NULL,
   CONSTRAINT pk_students PRIMARY KEY (id)
);

ALTER TABLE students ADD CONSTRAINT FK_STUDENTS_ON_GROUP FOREIGN KEY (group_id) REFERENCES `groups` (id);

CREATE TABLE event_module (
  id BIGINT AUTO_INCREMENT NOT NULL,
   number VARCHAR(255) NOT NULL,
   title VARCHAR(255) NOT NULL,
   CONSTRAINT pk_event_module PRIMARY KEY (id)
);

CREATE TABLE event_plan (
  id BIGINT AUTO_INCREMENT NOT NULL,
   event_module_id BIGINT NULL,
   title VARCHAR(255) NOT NULL,
   month INT NOT NULL,
   CONSTRAINT pk_event_plan PRIMARY KEY (id)
);

ALTER TABLE event_plan ADD CONSTRAINT FK_EVENT_PLAN_ON_EVENT_MODULE FOREIGN KEY (event_module_id) REFERENCES event_module (id);

CREATE TABLE events (
  id BIGINT AUTO_INCREMENT NOT NULL,
   title VARCHAR(255) NOT NULL,
   date date NOT NULL,
   points INT NOT NULL,
   CONSTRAINT pk_events PRIMARY KEY (id)
);

CREATE TABLE students_events (
  events_id BIGINT NOT NULL,
   student_id BIGINT NOT NULL,
   CONSTRAINT pk_students_events PRIMARY KEY (events_id, student_id)
);

ALTER TABLE students_events ADD CONSTRAINT fk_stueve_on_event FOREIGN KEY (events_id) REFERENCES events (id);

ALTER TABLE students_events ADD CONSTRAINT fk_stueve_on_student FOREIGN KEY (student_id) REFERENCES students (id);
