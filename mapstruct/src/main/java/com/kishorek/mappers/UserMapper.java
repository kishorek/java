package com.kishorek.mappers;

import com.kishorek.models.User;
import com.kishorek.models.UserResponse;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Mapping(expression = "java(user.getFirstName() + \" \" + user.getLastName())", target = "displayName")
    @Mapping(source = "menuVisible", target = "showMenu")
    @AuditFieldsMapping
    UserResponse userToUserResponse(User user);

    @InheritInverseConfiguration
    User userResponseToUser(UserResponse userResponse);

    void updateUserFromResponse(UserResponse userResponse, @MappingTarget User user);

}
