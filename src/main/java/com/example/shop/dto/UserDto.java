package com.example.shop.dto;

import com.example.shop.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private String country;
    private String username;
    private AddressDto addressDto;

    public User convertToUser() {
        return User.builder()
                .country(country)
                .createTime(LocalDateTime.now())
                .name(name)
                .username(username)
                .address(addressDto == null ? null : addressDto.convertToAddress())
                .build();
    }

}
