package com.bankingeen.backofficeservice.model.contract.admin;

import com.bankingeen.backofficeservice.model.contract.ResponseHeader;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    @Getter
    @Setter
    private ResponseHeader responseHeader;

    public BaseResponse() {
        this.responseHeader = new ResponseHeader();
    }

    public void setFailureInfo(String code, String description) {

        responseHeader = new ResponseHeader(false, code, description);
    }

    public void setSuccessInfo() {

        responseHeader = new ResponseHeader(true, "0", "islem basarili");
    }
}
