package com.nrkt.studentcoursegraphql.repository

import com.nrkt.studentcoursegraphql.model.Instructor
import org.springframework.data.repository.CrudRepository

interface InstructorRepository : CrudRepository<Instructor, String> {
}