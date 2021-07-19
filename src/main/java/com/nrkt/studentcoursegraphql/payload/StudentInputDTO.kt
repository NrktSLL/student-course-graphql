package com.nrkt.studentcoursegraphql.payload

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class StudentInputDTO(
    @JsonProperty("name")
    var name: String,
    @JsonProperty("lastname")
    var lastname: String,
    @JsonProperty("information")
    var information: InformationDTO,
    @JsonProperty("courses")
    var courses: Set<String>
) : Serializable