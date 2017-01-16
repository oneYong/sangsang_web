package com.web.sangsang.framework.exceptions.vo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * Created by WYKIM on 2017-01-16.
 */
@Data
public class RestErrorInfo {
    private int code;
    private String message;

    public RestErrorInfo(){}

    public RestErrorInfo(int code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        String returnVal = "";
        try{
            ObjectMapper mapper = new ObjectMapper();
            returnVal =  mapper.writeValueAsString(this);
        } catch (Exception e){
            returnVal = null;
        }
        return returnVal;
    }
}
