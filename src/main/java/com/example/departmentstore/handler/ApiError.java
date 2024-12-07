package com.example.departmentstore.handler;


import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiError {
    private HttpStatus httpStatus;

    private String message;

    private List<String> subError;



}
