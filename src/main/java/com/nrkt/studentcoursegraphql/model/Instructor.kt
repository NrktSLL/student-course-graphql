package com.nrkt.studentcoursegraphql.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.Hibernate
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*
import java.io.Serializable

@Entity
@Table(name = "instructor")
data class Instructor(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JsonProperty("id")
    val id: String? = "",
    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    val name: String? = "",
    @Column(name = "lastname", nullable = false)
    @JsonProperty("lastname")
    val lastname: String? = "",

    @OneToOne(
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "course_id", nullable = false)
    @JsonProperty("information")
    val information: Information?

) : Serializable {
    constructor(name: String?, lastname: String?, information: Information) : this(
        "",
        name = name,
        lastname = lastname,
        information = information
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Instructor

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 1241250265

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(name = $name , lastname = $lastname , information = $information )"
    }
}