package com.kishorek.mappers;

import com.kishorek.models.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {

    AddressMapper mapper = Mappers.getMapper(AddressMapper.class);

    Address addressFromMap(Map<String, String> addressMap);
}
