package com.tyb.fishhost.expand;

import lombok.Data;

@Data
public class BaseResponse {

    public BaseResponse() {
    }

    public BaseResponse(String message) {
        this.setMessage(message);
    }

    private boolean success;

    private String code;

    private String message;
}
