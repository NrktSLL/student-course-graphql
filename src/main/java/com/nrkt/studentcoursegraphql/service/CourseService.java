package com.nrkt.studentcoursegraphql.service;

import com.nrkt.studentcoursegraphql.error.NotFoundError;
import com.nrkt.studentcoursegraphql.mapper.CourseMapper;
import com.nrkt.studentcoursegraphql.model.Course;
import com.nrkt.studentcoursegraphql.payload.CourseInputDTO;
import com.nrkt.studentcoursegraphql.repository.CourseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class CourseService {

    CourseRepository courseRepository;
    CourseMapper courseMapper;

    public Course addCourse(CourseInputDTO newCourse) {
        var course = courseMapper.courseDtoToCourse(newCourse);
        return courseRepository.save(course);
    }

    public Course getCourse(String courseId) {
        return courseRepository
                .findById(courseId)
                .orElseThrow(() -> new NotFoundError("course not found: " + courseId));
    }
}
