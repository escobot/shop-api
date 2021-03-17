package com.example.shop.service;

import com.example.shop.dto.UserDto;
import com.example.shop.model.User;
import com.example.shop.repository.IUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest(properties = "spring.profiles.active:test")
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRepository userRepository;

    @Test
    public void test_saveUser() {
        UserDto userDto = UserDto.builder()
                .country("US")
                .name("Joe")
                .username("joe1")
                .build();

        userService.saveUser(userDto.convertToUser());

        List<User> users = userRepository.findAll();

        Assertions.assertThat(users).hasSize(1);
    }

//    @Test
//    public void test_findUsersByCountry() {
//        UserDto userDto1 = UserDto.builder()
//                .country("US")
//                .name("Joe")
//                .username("joe1")
//                .build();
//
//        UserDto userDto2 = UserDto.builder()
//                .country("US")
//                .name("Max")
//                .username("max1")
//                .build();
//
//        UserDto userDto3 = UserDto.builder()
//                .country("CA")
//                .name("Tim")
//                .username("tim1")
//                .build();
//
//        userService.saveUser(userDto1.convertToUser());
//        userService.saveUser(userDto2.convertToUser());
//        userService.saveUser(userDto3.convertToUser());
//
//        List<User> usersFromUS = userRepository.findByCountryAsCustom("US");
//
//        Assertions.assertThat(usersFromUS).hasSize(2);
//
//        List<User> usersFromCA = userRepository.findByCountryAsCustom("CA");
//
//        Assertions.assertThat(usersFromCA).hasSize(1);
//    }
}
