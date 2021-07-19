USE course;

BEGIN;

SET
@address_id = uuid();

INSERT INTO address (id, address1, address2, city, state)
VALUES (@address_id, 'zeytinburnu', NULL, 'Istanbul', NULL)
ON DUPLICATE KEY UPDATE address1 = 'zeytinburnu';

SET
@information_id = uuid();

INSERT INTO information (id, email, phone, address_id)
VALUES (@information_id, 'aa@gmail.com', 555455555, @address_id)
ON DUPLICATE KEY UPDATE email = 'aa@gmail.com';

SET
@student_id = uuid();

INSERT INTO student (id, name, lastname, information_id)
VALUES (@student_id, 'nrkt', 'sll', @information_id)
ON DUPLICATE KEY UPDATE name = 'nrkt';

SET
@course_id_one = uuid();

INSERT INTO course(id, title)
VALUES (@course_id_one, 'Java')
ON DUPLICATE KEY UPDATE title = 'Java';

SET
@course_id_two = uuid();

INSERT INTO course(id, title)
VALUES (@course_id_two, 'C#')
ON DUPLICATE KEY UPDATE title = 'C#';

INSERT INTO course_membership (course_id, student_id)
VALUES (@course_id_one, @student_id)
ON DUPLICATE KEY UPDATE course_id = @course_id_one;

INSERT INTO course_membership (course_id, student_id)
VALUES (@course_id_two, @student_id)
ON DUPLICATE KEY UPDATE course_id = @course_id_two;

INSERT INTO course(id, title)
VALUES (uuid(), 'GoLang')
ON DUPLICATE KEY UPDATE title = 'GoLang';

COMMIT;
