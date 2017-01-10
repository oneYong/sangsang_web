package com.web.sangsang.cmm.util;

import lombok.Data;

/**
 * Created by WYKIM on 2017-01-10.
 */
@Data
public class CmmException extends Exception {
    private CmmMessage cmmMessage;

    public CmmException(String errorMessage){
        super(errorMessage);
    }
}
