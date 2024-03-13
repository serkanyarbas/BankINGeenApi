package com.bankingeen.backofficeservice.model.contract;

import lombok.Getter;
import lombok.Setter;

public class ResponseHeader {

    @Getter
    @Setter
    private boolean isSuccess;

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String description;

    public ResponseHeader(boolean isSuccess, String code, String description) {

        this.isSuccess = isSuccess;
        this.code = code;
        this.description = description;
    }
}
