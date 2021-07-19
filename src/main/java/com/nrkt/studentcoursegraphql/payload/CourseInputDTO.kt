package com.nrkt.studentcoursegraphql.payload

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class CourseInputDTO(
    @JsonProperty("title")
    var title: String?,
) : Serializable