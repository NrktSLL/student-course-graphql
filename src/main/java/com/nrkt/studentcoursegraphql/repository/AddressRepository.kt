package com.nrkt.studentcoursegraphql.repository

import com.nrkt.studentcoursegraphql.model.Address
import org.springframework.data.repository.CrudRepository

interface AddressRepository : CrudRepository<Address, String> {
}