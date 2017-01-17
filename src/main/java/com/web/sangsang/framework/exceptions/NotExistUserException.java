package com.web.sangsang.framework.exceptions;

import com.web.sangsang.framework.exceptions.vo.RestErrorInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * Created by WYKIM on 2017-01-16.
 */
@Repository
public class NotExistUserException extends RuntimeException {

    @Value("${not.exist.user.code}")
    private int code;
    @Value("${not.exist.user.message}")
    private String message;

    @Override
    public String toString(){
        return new RestErrorInfo(this.code,this.message).toString();
    }

}
