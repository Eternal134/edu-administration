package com.example.eduadministration.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BaseResponse {

    private String code;

    private String errorMessage;

    private List<?> data;

    public BaseResponse(String code) {
        this.code = code;
    }

    public BaseResponse(String code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }
}
