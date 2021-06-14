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
public class BaseResponse<T> {

    private String code;

    private String errorMessage;

    /**
     * 保存列表类型结果
     */
    private List<T> data;
}
