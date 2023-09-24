package com.example.ems.dao.user;

import com.example.ems.entity.User;

public interface UserDAO {

    void addUser(User user);

    void updateUser(User user);

    User findUserByEmail(String email);

    User deleteUserByEmail(String email);
}
