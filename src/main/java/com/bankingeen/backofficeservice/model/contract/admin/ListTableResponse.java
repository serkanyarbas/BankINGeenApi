package com.bankingeen.backofficeservice.model.contract.admin;

import com.bankingeen.backofficeservice.model.contract.ResponseHeader;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ListTableResponse extends BaseResponse{

    @Getter
    @Setter
    private List<String> tableNames;
}