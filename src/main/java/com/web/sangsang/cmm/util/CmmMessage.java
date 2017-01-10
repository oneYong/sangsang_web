package com.web.sangsang.cmm.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * Created by WYKIM on 2017-01-10.
 */
@Data
public class CmmMessage {
    private String message;
    private Integer successCount;

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
