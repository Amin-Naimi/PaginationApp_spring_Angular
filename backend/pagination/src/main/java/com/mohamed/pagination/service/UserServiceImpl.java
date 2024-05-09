package com.mohamed.pagination.service;

import com.mohamed.pagination.dto.Response;
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
    public Response get_Users(String name, int page, int size) {
        Page<User> userPage =  userRepo.findUsersByNameContaining(name, PageRequest.of(page,size));
        int pageNumbers = userPage.getTotalPages();
        List<User> userPageContent = userPage.getContent();
        return new Response(userPageContent,pageNumbers);
    }
}
