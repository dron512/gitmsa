package com.green.userservice.user.service;

import com.green.userservice.user.jpa.UserEntity;
import com.green.userservice.user.vo.UserRequest;
import com.green.userservice.user.vo.UserResponse;
import org.springframework.stereotype.Service;


public interface UserService {
    UserResponse join(UserRequest userRequest);
}
