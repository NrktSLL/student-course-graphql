package com.nrkt.studentcoursegraphql.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.Hibernate
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*
import java.io.Serializable

@Entity
@Table(name = "address")
data class Address(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JsonProperty("id")
    val id: String? = "",
    @Column(name = "address1")
    @JsonProperty("address1")
    val firstAddress: String? = "",
    @Column(name = "address2")
    @JsonProperty("address2")
    val secondAddress: String? = "",
    @Column(name = "city")
    @JsonProperty("city")
    val city: String? = "",
    @Column(name = "state")
    @JsonProperty("state")
    val state: String? = ""
): Serializable{

    constructor(firstAddress: String?, secondAddress: String?, city: String?, state: String) : this(
        "",
        firstAddress = firstAddress,
        secondAddress = secondAddress,
        city = city,
        state = state
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Address

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 1580479556

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(firstAddress = $firstAddress , secondAddress = $secondAddress , city = $city , state = $state )"
    }

}