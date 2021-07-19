package com.nrkt.studentcoursegraphql.model.keys

import org.hibernate.Hibernate
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class CourseInstructorKey(
    @Column(name = "course_id")
    val courseId: String,

    @Column(name = "instructor_id")
    val instructorId: String

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CourseInstructorKey

        if (courseId != other.courseId) return false
        if (instructorId != other.instructorId) return false
        return true
    }

    override fun hashCode(): Int {
        var result: Int = courseId.hashCode()
        result = 31 * result + instructorId.hashCode()
        return result
    }

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(courseId = $courseId , instructorId = $instructorId )"
    }
}