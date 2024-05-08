package com.mohamed.pagination.service;

import com.mohamed.pagination.entity.User;
import com.mohamed.pagination.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public List<User> get_Users(String name, int page, int size) {
        Page<User> userPage =  userRepo.findByNameContaining(name, PageRequest.of(page,size));
        return userPage.getContent();
    }
}
