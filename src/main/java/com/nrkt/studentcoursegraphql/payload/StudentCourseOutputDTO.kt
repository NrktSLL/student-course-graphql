package com.nrkt.studentcoursegraphql.payload

import com.fasterxml.jackson.annotation.JsonProperty
import com.nrkt.studentcoursegraphql.model.Course
import com.nrkt.studentcoursegraphql.model.Information
import java.io.Serializable

data class StudentCourseOutputDTO(
    @JsonProperty("id")
    var id: String?,
    @JsonProperty("name")
    var name: String?,
    @JsonProperty("lastname")
    var lastname: String?,
    @JsonProperty("information")
    var information: Information?,
    @JsonProperty("courses")
    var courses: Set<Course>?
) : Serializable