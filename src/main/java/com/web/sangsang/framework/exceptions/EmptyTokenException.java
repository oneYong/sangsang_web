package com.web.sangsang.framework.exceptions;

import com.web.sangsang.framework.exceptions.vo.RestErrorInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * Created by WYKIM on 2017-01-16.
 */
@Repository
public class EmptyTokenException extends RuntimeException {

    @Value("${empty.token.code}")
    private int code;
    @Value("${empty.token.message}")
    private String message;

    @Override
    public String toString(){
        return new RestErrorInfo(this.code,this.message).toString();
    }

}
