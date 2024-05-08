package com.mohamed.pagination.controller;

import com.mohamed.pagination.dto.HttpCustomeResponse;
import com.mohamed.pagination.entity.User;
import com.mohamed.pagination.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/pagination")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/get/users")
    public ResponseEntity<List<User>> getUsers(@RequestParam("name") Optional<String> name,
                                               @RequestParam("page") Optional<Integer> page,
                                               @RequestParam("size") Optional<Integer> size) {
        int pageNumber = page.orElse(0);
        int pageSize = size.orElse(10);
        List<User> users = userService.get_Users(name.orElse(""), pageNumber, pageSize);
        return ResponseEntity.ok().body(users);
    }
}
