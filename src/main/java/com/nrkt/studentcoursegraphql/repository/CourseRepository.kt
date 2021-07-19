package com.nrkt.studentcoursegraphql.repository

import com.nrkt.studentcoursegraphql.model.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, String> {
    fun findAllByIdIn(courseId: Set<String>): Set<Course>
}