package com.mohamed.pagination.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response<T>{
    private List<T> userList;
    private int pageNumbers;
    private int currentPage;
}
