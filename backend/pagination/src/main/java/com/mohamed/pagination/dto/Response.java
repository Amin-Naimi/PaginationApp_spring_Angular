package com.mohamed.pagination.dto;

import com.mohamed.pagination.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private List<User> userList;
    private int pageNumbers;
    private int currentPage;
}
