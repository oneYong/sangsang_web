package com.web.sangsang.cmm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * Created by WYKIM on 2017-01-17.
 */
@Data
public class MakeTokenInfo {
    private String source;
    private String sourceId;
    private String name;
    private String currentTime;

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
