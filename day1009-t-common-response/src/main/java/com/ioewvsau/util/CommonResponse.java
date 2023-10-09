package com.ioewvsau.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    private Integer code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public static CommonResponse ok(Object data) {
        return new CommonResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    public static CommonResponse ok(Integer status, Object data) {
        return new CommonResponse(status, null, data);
    }

    public static CommonResponse fail(String message) {
        return new CommonResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, null);
    }

    public static CommonResponse fail(Integer status, String message) {
        return new CommonResponse(status, "fail", null);
    }
}
