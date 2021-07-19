package com.nrkt.studentcoursegraphql.mapper

import com.nrkt.studentcoursegraphql.model.Information
import com.nrkt.studentcoursegraphql.payload.InformationDTO
import org.springframework.stereotype.Component

@Component
class InformationMapper {

    private val addressMapper = AddressMapper()

    fun informationDtoDtoInformation(information: InformationDTO): Information {
        return Information(
            information.email,
            information.phone,
            addressMapper.addressDtoToAddress(information.address)
        )
    }
}