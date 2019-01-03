package com.b2w.swapi.domain.error;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ApiError {

    private String code;
    private String reason;
    private String message;

    public ApiError(ApiException ex) {
        this.code = ex.getCode();
        this.reason = ex.getReason();
        this.message = ex.getMessage();
    }
}
