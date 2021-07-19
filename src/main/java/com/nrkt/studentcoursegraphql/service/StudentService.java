package com.nrkt.studentcoursegraphql.service;

import com.nrkt.studentcoursegraphql.error.NotFoundError;
import com.nrkt.studentcoursegraphql.mapper.StudentMapper;
import com.nrkt.studentcoursegraphql.model.Course;
import com.nrkt.studentcoursegraphql.model.CourseMembership;
import com.nrkt.studentcoursegraphql.model.Student;
import com.nrkt.studentcoursegraphql.model.keys.StudentCourseKey;
import com.nrkt.studentcoursegraphql.payload.StudentCourseOutputDTO;
import com.nrkt.studentcoursegraphql.payload.StudentInputDTO;
import com.nrkt.studentcoursegraphql.repository.CourseRepository;
import com.nrkt.studentcoursegraphql.repository.StudentCourseRepository;
import com.nrkt.studentcoursegraphql.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class StudentService {

    StudentRepository studentRepository;
    CourseRepository courseRepository;
    StudentCourseRepository studentCourseRepository;
    StudentMapper studentMapper;

    public StudentCourseOutputDTO addStudent(StudentInputDTO newStudent) {
        var student = studentMapper.studentDtoToStudent(newStudent);
        student = studentRepository.save(student);
        var courses = courseRepository.findAllByIdIn(newStudent.getCourses());
        for (Course course : courses) {
            CourseMembership courseMembership = new CourseMembership(new StudentCourseKey(
                    Objects.requireNonNull(course.getId()),
                    Objects.requireNonNull(student.getId())),
                    course,
                    student);

            studentCourseRepository.save(courseMembership);
        }
        return studentMapper.studentToStudentCourseOutputDTO(student, courses);
    }

    public StudentCourseOutputDTO getStudentCourses(String studentId) {
        var student = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new NotFoundError("Student not found: " + studentId));

        var courses = studentCourseRepository.findAllByStudentId(studentId)
                .stream()
                .map(CourseMembership::getCourse)
                .collect(Collectors.toSet());

        return studentMapper.studentToStudentCourseOutputDTO(student, courses);
    }

    public Student getStudent(String studentId) {
        return studentRepository
                .findById(studentId)
                .orElseThrow(() -> new NotFoundError("Student not found: " + studentId));
    }

    public void deleteStudent(String studentId) {
        studentRepository.deleteById(studentId);
        studentCourseRepository.deleteByStudentId(studentId);
    }
}
