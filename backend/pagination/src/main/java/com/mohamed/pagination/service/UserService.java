package com.mohamed.pagination.service;

import com.mohamed.pagination.entity.User;

import java.util.List;

public interface UserService {
    List<User> get_Users(String name, int page, int size);
}
