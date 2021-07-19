package com.nrkt.studentcoursegraphql.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.nrkt.studentcoursegraphql.model.keys.CourseInstructorKey
import org.hibernate.Hibernate
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "cource_instructor")
data class CourseInstructor(
    @EmbeddedId
    @JsonProperty("id")
    val id: CourseInstructorKey,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    @JsonProperty("course")
    val course: Course,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("instructor_id")
    @JoinColumn(name = "instructor_id")
    @JsonProperty("instructor")
    val instructor: Instructor

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CourseInstructor

        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(EmbeddedId = $id )"
    }
}

