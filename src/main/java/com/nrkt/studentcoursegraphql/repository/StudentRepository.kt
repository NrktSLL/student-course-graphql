package com.nrkt.studentcoursegraphql.repository

import com.nrkt.studentcoursegraphql.model.Student
import org.springframework.data.repository.CrudRepository

interface StudentRepository : CrudRepository<Student, String> {
}