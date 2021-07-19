package com.nrkt.studentcoursegraphql.payload

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class InformationDTO(
    @JsonProperty("email")
    var email: String?,
    @JsonProperty("phone")
    var phone: Int?,
    @JsonProperty("address")
    var address: AddressDTO
) : Serializable