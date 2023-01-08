package com.kishorek;

import com.kishorek.models.User;
import com.kishorek.models.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Mapping(expression = "java(user.getFirstName() + \" \" + user.getLastName())", target = "displayName")
    UserResponse userToUserResponse(User user);
}
