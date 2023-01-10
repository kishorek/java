package com.kishorek;

import com.kishorek.mappers.AddressMapper;
import com.kishorek.mappers.UserMapper;
import com.kishorek.models.Address;
import com.kishorek.models.User;
import com.kishorek.models.UserResponse;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Address address = new Address();
        address.setAddrLine1("221B Baker Street");
        address.setAddrLine2("");
        address.setCity("London");

        User user = new User().setMainRole("Admin");
        user.setEmail("john@example.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setMenuVisible(true);
        user.setAddress(address);
//        user.setLastLoggedOn(new Date());

        UserResponse userResponse = UserMapper.mapper.userToUserResponse(user);
        System.out.println(userResponse);

        /*User newUser = new User();
        UserMapper.mapper.updateUserFromResponse(userResponse, newUser);
        System.out.println(newUser);*/

        /*System.out.println(UserMapper.mapper.userResponseToUser(userResponse));*/

        Map addressMap = Map.of("addrLine1","10 Downing Street");
        System.out.println(AddressMapper.mapper.addressFromMap(addressMap));
    }
}