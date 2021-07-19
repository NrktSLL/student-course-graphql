package com.nrkt.studentcoursegraphql.model.keys

import org.hibernate.Hibernate
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class StudentCourseKey(
    @Column(name = "course_id")
    val courseId: String,

    @Column(name = "student_id")
    val studentId: String

) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as StudentCourseKey

        if (courseId != other.courseId) return false
        if (studentId != other.studentId) return false
        return true
    }

    override fun hashCode(): Int {
        var result: Int = courseId.hashCode()
        result = 31 * result + studentId.hashCode()
        return result
    }

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(courseId = $courseId , studentId = $studentId )"
    }
}