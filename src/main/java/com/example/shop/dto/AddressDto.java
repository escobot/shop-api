package com.example.shop.dto;

import com.example.shop.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String city;
    private Integer postCode;

    public Address convertToAddress() {
        return Address.builder()
                .city(city)
                .postCode(postCode)
                .build();
    }
}
