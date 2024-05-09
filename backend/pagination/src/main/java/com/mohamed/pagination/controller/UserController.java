package com.mohamed.pagination.controller;

import com.mohamed.pagination.dto.Response;
import com.mohamed.pagination.entity.User;
import com.mohamed.pagination.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagination")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService userService;
    @GetMapping("/get/users")
    public ResponseEntity<Response> getUsers(@RequestParam("name") Optional<String> name,
                                             @RequestParam("page") Optional<Integer> page,
                                             @RequestParam("size") Optional<Integer> size) {
        int pageNumber = page.orElse(0);
        int pageSize = size.orElse(10);
        Response response = userService.get_Users(name.orElse(""), pageNumber, pageSize);

        return ResponseEntity.ok().body(response);
    }
}
