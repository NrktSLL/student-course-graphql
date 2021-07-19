package com.nrkt.studentcoursegraphql.mapper

import com.nrkt.studentcoursegraphql.model.Course
import com.nrkt.studentcoursegraphql.payload.CourseInputDTO
import org.springframework.stereotype.Component

@Component
class CourseMapper {

    fun courseDtoToCourse(courseInputDTO: CourseInputDTO): Course {
        return Course(courseInputDTO.title)
    }
}