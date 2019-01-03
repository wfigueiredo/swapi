package com.b2w.swapi.domain.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ApiException extends RuntimeException {

    private String code;
    private String reason;
    private String message;
    private HttpStatus statusCode;
}
