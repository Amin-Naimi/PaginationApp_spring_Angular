package com.mohamed.pagination.controller;

import com.mohamed.pagination.dto.HttpCustomeResponse;
import com.mohamed.pagination.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import static javax.security.auth.callback.ConfirmationCallback.OK;

@RestController
@RequestMapping("/pagination")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/get/users")
    public ResponseEntity<HttpCustomeResponse> getUsers(@RequestParam("name")Optional<String> name,
                                                        @RequestParam("page")Optional<Integer> page,
                                                        @RequestParam("size")Optional<Integer> size){
    return ResponseEntity.ok().body(
            HttpCustomeResponse.builder()
                    .timeStamp(LocalDateTime.now().toString())
                    .statusCode(OK)
                    .status(HttpStatus.OK)
                    .message("Users Retrived")
                    .data(Map.of("page",userService.get_Users(name.orElse(""),page.orElse(0),size.orElse(5))))
                    .build());

    }
}
