package com.Sameera.smart_shopping.service.user;

import com.Sameera.smart_shopping.dto.UserDto;
import com.Sameera.smart_shopping.model.User;
import com.Sameera.smart_shopping.request.CreateUserRequest;
import com.Sameera.smart_shopping.request.UserUpdateRequest;

public interface IUserService {

    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUSer(Long userId);

    UserDto convertUserToDto(User user);
}
