package com.nrkt.studentcoursegraphql.mapper

import com.nrkt.studentcoursegraphql.model.Address
import com.nrkt.studentcoursegraphql.payload.AddressDTO
import org.springframework.stereotype.Component

@Component
class AddressMapper {
    fun addressDtoToAddress(address: AddressDTO): Address {
        return Address(
            address.firstAddress,
            address.secondAddress,
            address.city,
            address.state
        )
    }
}