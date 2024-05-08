package com.mohamed.pagination.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
public class HttpCustomeResponse {
    private String timeStamp;
    private int statusCode;
    private HttpStatus status;
    private String message;
    private Map<?,?> data;

}
