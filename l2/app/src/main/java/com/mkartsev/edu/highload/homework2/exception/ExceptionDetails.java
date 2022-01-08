package com.mkartsev.edu.highload.homework2.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ExceptionDetails {
    private Date timestamp;
    private String message;
    private String details;
}