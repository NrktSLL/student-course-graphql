package com.nrkt.studentcoursegraphql.repository

import com.nrkt.studentcoursegraphql.model.CourseInstructor
import com.nrkt.studentcoursegraphql.model.keys.CourseInstructorKey
import org.springframework.data.repository.CrudRepository

interface InstructorCourseRepository : CrudRepository<CourseInstructor, CourseInstructorKey> {
}