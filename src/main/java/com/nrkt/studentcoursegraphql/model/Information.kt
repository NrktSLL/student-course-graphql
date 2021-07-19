package com.nrkt.studentcoursegraphql.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.Hibernate
import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "information")
data class Information(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JsonProperty("id")
    val id: String? = "",
    @Column(name = "email")
    @JsonProperty("email")
    val email: String? = "",
    @Column(name = "phone")
    @JsonProperty("phone")
    val phone: Int? = -1,

    @OneToOne(
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @JsonProperty("address")
    val address: Address?,

    ) : Serializable {

    constructor(email: String?, phone: Int?, address: Address?) : this(
        "",
        email = email,
        phone = phone,
        address = address
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Information

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 995878508

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(email = $email , phone = $phone , address = $address )"
    }
}