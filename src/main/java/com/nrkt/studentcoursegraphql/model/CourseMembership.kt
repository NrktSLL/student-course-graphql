package com.nrkt.studentcoursegraphql.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.nrkt.studentcoursegraphql.model.keys.StudentCourseKey
import org.hibernate.Hibernate
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "course_membership")
data class CourseMembership(
    @EmbeddedId
    @JsonProperty("id")
    val id: StudentCourseKey,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    @JsonProperty("course")
    val course: Course,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    @JsonProperty("student")
    val student: Student

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CourseMembership

        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(EmbeddedId = $id )"
    }
}

