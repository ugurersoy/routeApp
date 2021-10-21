package com.test.routeApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorMessageResponseDto {
    private String errorCode;
    private String errorMessage;
}
