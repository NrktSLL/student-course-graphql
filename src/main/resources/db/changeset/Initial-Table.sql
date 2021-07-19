CREATE TABLE IF NOT EXISTS `student`
(
    `id`             varchar(255) PRIMARY KEY NOT NULL,
    `name`           varchar(255)             NOT NULL,
    `lastname`       varchar(255)             NOT NULL,
    `information_id` varchar(255)
);

CREATE TABLE IF NOT EXISTS `address`
(
    `id`       varchar(255) PRIMARY KEY NOT NULL,
    `address1` varchar(255),
    `address2` varchar(255),
    `city`     varchar(255),
    `state`    varchar(255)
);

CREATE TABLE IF NOT EXISTS `information`
(
    `id`         varchar(255) PRIMARY KEY NOT NULL,
    `email`      varchar(255),
    `phone`      int,
    `address_id` varchar(255)
);

CREATE TABLE IF NOT EXISTS `course`
(
    `id`    varchar(255) PRIMARY KEY NOT NULL,
    `title` varchar(255),
    `code`  varchar(255)
);

CREATE TABLE IF NOT EXISTS `instructor`
(
    `id`             varchar(255) PRIMARY KEY NOT NULL,
    `name`           varchar(255)             NOT NULL,
    `lastname`       varchar(255)             NOT NULL,
    `information_id` varchar(255)
);

CREATE TABLE IF NOT EXISTS `course_membership`
(
    `course_id`  varchar(255),
    `student_id` varchar(255),
    CONSTRAINT FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
    CONSTRAINT FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
);

CREATE TABLE IF NOT EXISTS `instructor_course`
(
    `course_id`     varchar(255),
    `instructor_id` varchar(255),
    CONSTRAINT FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
    CONSTRAINT FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`)
);

ALTER TABLE `student` ADD FOREIGN KEY (`information_id`) REFERENCES `information` (`id`);

ALTER TABLE `instructor` ADD FOREIGN KEY (`information_id`) REFERENCES `information` (`id`);

ALTER TABLE `information` ADD FOREIGN KEY (`address_id`) REFERENCES `address` (`id`);
