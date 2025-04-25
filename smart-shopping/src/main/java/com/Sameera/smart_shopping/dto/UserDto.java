package com.Sameera.smart_shopping.dto;


import java.util.List;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastname;
    private String email;
    private List<OrderDto> orders;
    private CartDto cart;

}
