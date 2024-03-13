package com.bankingeen.backofficeservice.model.contract.admin;

import com.bankingeen.backofficeservice.model.contract.common.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ListTableColumnResponse extends BaseResponse {

    @Getter
    @Setter
    private List<Column> tableColumns;
}
