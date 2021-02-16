DROP TABLE IF EXISTS position;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS team_members;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS employee;


CREATE TABLE department
(
        department_number       CHAR(2)         PRIMARY KEY,
        department_name         VARCHAR(100)    NOT NULL
);

CREATE TABLE employee
(
        employee_number         SERIAL          PRIMARY KEY,
        name_first              VARCHAR(100)    NOT NULL,
        name_last               VARCHAR(100)    NOT NULL,
        gender                  VARCHAR(30)     NOT NULL,
        date_of_birth           DATE            NOT NULL,
        date_of_hire            DATE            NOT NULL
);
    
CREATE TABLE position
(
        employee_number         INT             NOT NULL,
        department_number       CHAR(2)         NOT NULL,
        job_title               VARCHAR(100)    NOT NULL,
          
        CONSTRAINT pk_position_info PRIMARY KEY (employee_number, department_number),
        CONSTRAINT fk_position_employee FOREIGN KEY (employee_number) REFERENCES employee (employee_number),
        CONSTRAINT fk_position_department FOREIGN KEY (department_number) REFERENCES department (department_number)
);

CREATE TABLE project
(
        project_number          SERIAL          PRIMARY KEY,
        project_name            VARCHAR(100)    NOT NULL,
        start_date              DATE            NOT NULL  
);

CREATE TABLE team_members
(       
        employee_number         INT             NOT NULL,
        project_number          INT             NOT NULL, 
        
        CONSTRAINT pk_project_members PRIMARY KEY (employee_number, project_number),
        CONSTRAINT fk_team_project FOREIGN KEY (project_number) REFERENCES project (project_number),
        CONSTRAINT fk_team_employee FOREIGN KEY (employee_number) REFERENCES employee (employee_number)
);

INSERT INTO department (department_number, department_name)
VALUES  ('21', 'Hall of Fame'),
        ('66', 'Ownership'),
        ('58', 'Defense'),
        ('87', 'Offense'),
        ('71', 'Power Play'),
        ('17', 'Penalty Kill')
;

INSERT INTO employee (employee_number, name_first, name_last, gender, date_of_birth, date_of_hire)
VALUES  (DEFAULT, 'Mario', 'Lemieux', 'Male', '1965-10-05', '1984-10-11'),
        (DEFAULT, 'Ron', 'Burkle', 'Male', '1952-11-12', '1999-09-03'),
        (DEFAULT, 'Debra', 'Cafaro', 'Female', '1957-12-15', '2016-12-01'),
        (DEFAULT, 'Rob', 'Scuderi', 'Male', '1978-12-30', '2004-02-12'),
        (DEFAULT, 'Ulf', 'Samuelsson', 'Male', '1964-03-26', '1991-03-05'),
        (DEFAULT, 'Trevor', 'Daley', 'Male', '1983-10-09', '2015-12-16'),
        (DEFAULT, 'Matt', 'Cullen', 'Male', '1976-11-02', '2015-10-08'),
        (DEFAULT, 'Mark', 'Recchi', 'Male', '1968-02-01', '1988-11-16'),
        (DEFAULT, 'Pascal', 'Dupuis', 'Male', '1979-04-07', '2008-02-28'),
        (DEFAULT, 'Gary', 'Roberts', 'Male', '1966-05-23', '2007-03-01'),
        (DEFAULT, 'Jordan', 'Staal', 'Male', '1988-09-10', '2006-10-05'),
        (DEFAULT, 'Jarome', 'Iginla', 'Male', '1977-07-01', '2013-03-30'),
        (DEFAULT, 'Bill', 'Guerin', 'Male', '1970-11-09', '2009-03-05')
;

INSERT INTO position (employee_number, department_number, job_title)
VALUES  ('1', (SELECT department_number FROM department WHERE department_name = 'Hall of Fame'), 'Le Magnifique'),
        ('1', (SELECT department_number FROM department WHERE department_name = 'Ownership'), 'Savior'),
        ('1', (SELECT department_number FROM department WHERE department_name = 'Offense'), 'Super Mario'),
        ('2', (SELECT department_number FROM department WHERE department_name = 'Ownership'), 'Co-Owner'),
        ('3', (SELECT department_number FROM department WHERE department_name = 'Ownership'), 'Co-Owner'),
        ('4', (SELECT department_number FROM department WHERE department_name = 'Defense'), 'Defenseman'),
        ('4', (SELECT department_number FROM department WHERE department_name = 'Penalty Kill'), 'Stay-at-Home Defenseman'),
        ('5', (SELECT department_number FROM department WHERE department_name = 'Defense'), 'Defenseman'),
        ('5', (SELECT department_number FROM department WHERE department_name = 'Penalty Kill'), 'Enforcer'),
        ('6', (SELECT department_number FROM department WHERE department_name = 'Defense'), 'Defenseman'),
        ('6', (SELECT department_number FROM department WHERE department_name = 'Power Play'), 'Quarterback'),
        ('7', (SELECT department_number FROM department WHERE department_name = 'Offense'), 'Center'),
        ('7', (SELECT department_number FROM department WHERE department_name = 'Penalty Kill'), 'Two-Way Center'),
        ('8', (SELECT department_number FROM department WHERE department_name = 'Hall of Fame'), 'Wrecking Ball'),
        ('8', (SELECT department_number FROM department WHERE department_name = 'Offense'), 'Right Wing'),
        ('8', (SELECT department_number FROM department WHERE department_name = 'Power Play'), 'Grinder'),
        ('9', (SELECT department_number FROM department WHERE department_name = 'Offense'), 'Left Wing'),
        ('10', (SELECT department_number FROM department WHERE department_name = 'Offense'), 'Left Wing'),
        ('10', (SELECT department_number FROM department WHERE department_name = 'Penalty Kill'), 'Grinder'),
        ('11', (SELECT department_number FROM department WHERE department_name = 'Offense'), 'Center'),
        ('11', (SELECT department_number FROM department WHERE department_name = 'Penalty Kill'), 'Two-Way Center'),
        ('12', (SELECT department_number FROM department WHERE department_name = 'Hall of Fame'), 'Iggy'),
        ('12', (SELECT department_number FROM department WHERE department_name = 'Offense'), 'Right Wing'),
        ('12', (SELECT department_number FROM department WHERE department_name = 'Power Play'), 'Power Forward'),
        ('13', (SELECT department_number FROM department WHERE department_name = 'Offense'), 'Right Wing')
;

INSERT INTO project (project_number, project_name, start_date)
VALUES  (DEFAULT, 'Meet Lord Stanley!', '1991-05-25'),
        (DEFAULT, 'Retire as a Penguin', '1997-11-19'),
        (DEFAULT, 'Banquish the 90s Logo', '20002-10-10'),
        (DEFAULT, 'No Medal for Second Place', '2008-06-04'),
        (DEFAULT, 'Build a New Arena', '2010-08-01'),  
        (DEFAULT, 'Win One for the Thumb!', '2017-06-11')         
;
   
INSERT INTO team_members (employee_number, project_number)
VALUES  ((SELECT employee_number FROM employee WHERE name_first = 'Mario' AND name_last = 'Lemieux'), (SELECT project_number FROM project WHERE project_name LIKE 'Meet%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Mario' AND name_last = 'Lemieux'), (SELECT project_number FROM project WHERE project_name LIKE 'Retire%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Mario' AND name_last = 'Lemieux'), (SELECT project_number FROM project WHERE project_name LIKE 'Ban%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Mario' AND name_last = 'Lemieux'), (SELECT project_number FROM project WHERE project_name LIKE 'No%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Mario' AND name_last = 'Lemieux'), (SELECT project_number FROM project WHERE project_name LIKE 'Build%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Mario' AND name_last = 'Lemieux'), (SELECT project_number FROM project WHERE project_name LIKE 'Win%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Ron' AND name_last = 'Burkle'), (SELECT project_number FROM project WHERE project_name LIKE 'Ban%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Ron' AND name_last = 'Burkle'), (SELECT project_number FROM project WHERE project_name LIKE 'No%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Ron' AND name_last = 'Burkle'), (SELECT project_number FROM project WHERE project_name LIKE 'Build%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Rob' AND name_last = 'Scuderi'), (SELECT project_number FROM project WHERE project_name LIKE 'No%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Ulf' AND name_last = 'Samuelsson'), (SELECT project_number FROM project WHERE project_name LIKE 'Meet%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Matt' AND name_last = 'Cullen'), (SELECT project_number FROM project WHERE project_name LIKE 'Retire%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Mark' AND name_last = 'Recchi'), (SELECT project_number FROM project WHERE project_name LIKE 'Meet%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Mark' AND name_last = 'Recchi'), (SELECT project_number FROM project WHERE project_name LIKE 'Win%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Pascal' AND name_last = 'Dupuis'), (SELECT project_number FROM project WHERE project_name LIKE 'No%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Pascal' AND name_last = 'Dupuis'), (SELECT project_number FROM project WHERE project_name LIKE 'Build%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Gary' AND name_last = 'Roberts'), (SELECT project_number FROM project WHERE project_name LIKE 'No%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Jordan' AND name_last = 'Staal'), (SELECT project_number FROM project WHERE project_name LIKE 'No%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Jordan' AND name_last = 'Staal'), (SELECT project_number FROM project WHERE project_name LIKE 'Build%')),
        ((SELECT employee_number FROM employee WHERE name_first = 'Bill' AND name_last = 'Guerin'), (SELECT project_number FROM project WHERE project_name LIKE 'Retire%'))
;