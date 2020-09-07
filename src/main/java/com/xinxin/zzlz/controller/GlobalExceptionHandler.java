package com.xinxin.zzlz.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final static String errorMessage = "请求失败";
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @ExceptionHandler(value = MultipartException.class)
    @ResponseBody
    public String fileUploadExceptionHandler(MultipartException exception, HttpServletResponse response) {
        System.out.println(exception.getMessage());
       return exception.getMessage();


    }



}

