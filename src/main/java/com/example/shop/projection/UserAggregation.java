package com.example.shop.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAggregation {
    private @Id String country;
    private Set<String> name;
}
