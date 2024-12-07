package com.example.departmentstore.handler;

import com.example.departmentstore.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFoundException(ResourceNotFoundException exception){
//        ApiError apiError= new ApiError();
//        apiError.setHttpStatus(HttpStatus.NOT_FOUND);
//        apiError.setMessage(exception.getMessage());
        ApiError apiError=ApiError.builder().message(exception.getMessage()).httpStatus(HttpStatus.NOT_FOUND).build();


        return  buildApiResponse(apiError);

    }

    private ResponseEntity<ApiResponse<?>> buildApiResponse(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getHttpStatus());
    }
}
