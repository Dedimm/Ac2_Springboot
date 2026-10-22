package com.example.ac2_ma.dto;

import java.util.List;

public class ApiErrorDTO {
    private List<String> errors;
    
     public ApiErrorDTO(String error) {
        this.errors = List.of(error);
    }

    public List<String> getErrors() {
        return errors;
    }
}
