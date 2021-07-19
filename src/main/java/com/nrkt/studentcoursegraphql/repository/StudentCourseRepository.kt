package com.nrkt.studentcoursegraphql.repository

import com.nrkt.studentcoursegraphql.model.CourseMembership
import com.nrkt.studentcoursegraphql.model.keys.StudentCourseKey
import org.springframework.data.repository.CrudRepository

interface StudentCourseRepository : CrudRepository<CourseMembership, StudentCourseKey> {
    fun findAllByStudentId(studentId: String): Set<CourseMembership>
    fun findAllByCourseId(courseId: String): Set<CourseMembership>
    fun deleteByStudentId(studentId: String): Void
}