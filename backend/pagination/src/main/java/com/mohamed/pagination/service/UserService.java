package com.mohamed.pagination.service;

import com.mohamed.pagination.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> get_Users(String name, int page, int size);
}
