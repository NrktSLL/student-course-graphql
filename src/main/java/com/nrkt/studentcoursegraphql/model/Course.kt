package com.nrkt.studentcoursegraphql.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.Hibernate
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*
import java.io.Serializable

@Entity
@Table(name = "course")
data class Course(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JsonProperty("id")
    val id: String? = "",
    @Column(name = "title", nullable = false)
    @JsonProperty("title")
    val title: String? = ""

) : Serializable {

    constructor(title: String?) : this(
        "",
        title = title
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Course

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 1702818130

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(title = $title)"
    }
}