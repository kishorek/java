package com.kishorek;

import com.kishorek.models.Address;
import com.kishorek.models.User;
import com.kishorek.models.UserResponse;

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
    }
}