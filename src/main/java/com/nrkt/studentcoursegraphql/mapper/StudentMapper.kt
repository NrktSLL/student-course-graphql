package com.nrkt.studentcoursegraphql.mapper

import com.nrkt.studentcoursegraphql.model.Course
import com.nrkt.studentcoursegraphql.model.Student
import com.nrkt.studentcoursegraphql.payload.StudentCourseOutputDTO
import com.nrkt.studentcoursegraphql.payload.StudentInputDTO
import org.springframework.stereotype.Component

@Component
class StudentMapper {

    private val informationMapper = InformationMapper()

    fun studentDtoToStudent(student: StudentInputDTO): Student {
        return Student(
            student.name,
            student.lastname,
            informationMapper.informationDtoDtoInformation(student.information)
        )
    }

    fun studentToStudentCourseOutputDTO(student: Student, courses: Set<Course>): StudentCourseOutputDTO {
        return StudentCourseOutputDTO(
            student.id,
            student.name,
            student.lastname,
            student.information,
            courses
        )
    }
}