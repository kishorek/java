package com.kishorek;

import com.kishorek.models.User;
import com.kishorek.models.UserResponse;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setEmail("john@example.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setShowMenu(true);
        user.setLastLoggedOn(new Date());

        UserResponse userResponse = UserMapper.mapper.userToUserResponse(user);
        System.out.println(userResponse);
    }
}