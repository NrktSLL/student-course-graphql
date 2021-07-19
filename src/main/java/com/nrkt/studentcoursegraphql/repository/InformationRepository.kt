package com.nrkt.studentcoursegraphql.repository

import com.nrkt.studentcoursegraphql.model.Information
import org.springframework.data.repository.CrudRepository

interface InformationRepository : CrudRepository<Information, String> {
}