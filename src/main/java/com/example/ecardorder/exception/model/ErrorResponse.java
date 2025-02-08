package com.example.ecardorder.exception.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class ErrorResponse {
    private String message;
    private String path;
    private LocalDateTime timestamp;
    private Map<String, String> errors;

}
