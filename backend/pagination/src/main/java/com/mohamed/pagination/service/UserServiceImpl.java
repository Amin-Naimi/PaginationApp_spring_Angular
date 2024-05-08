package com.mohamed.pagination.service;

import com.mohamed.pagination.entity.User;
import com.mohamed.pagination.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public Page<User> get_Users(String name, int page, int size) {
        return userRepo.findByNameContaining(name, PageRequest.of(page,size));
    }
}
