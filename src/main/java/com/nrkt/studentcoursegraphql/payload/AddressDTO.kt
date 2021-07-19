package com.nrkt.studentcoursegraphql.payload

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class AddressDTO(
    @JsonProperty("firstAddress")
    var firstAddress: String?,
    @JsonProperty("secondAddress")
    var secondAddress: String?,
    @JsonProperty("city")
    var city: String?,
    @JsonProperty("state")
    var state: String?
) : Serializable