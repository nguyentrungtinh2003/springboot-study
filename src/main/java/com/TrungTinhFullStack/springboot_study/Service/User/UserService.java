package com.TrungTinhFullStack.springboot_study.Service.User;

import com.TrungTinhFullStack.springboot_study.Entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    User getUserById(Long id);
    User addUser(User user);
    User updateUser(Long id,User user);
    User deleteUser(Long id);
}
