package com.web.sangsang.cmm.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.sangsang.cmm.vo.CmmMessage;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by WYKIM on 2017-01-17.
 */
@Component
public class CmmUtil {

    public static <T> T jsonStringToObject(String jsonStr, Class<T> classes) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, classes);
    }

    public static String getCurrentDateSeoul() {
        Calendar cal = Calendar.getInstance();
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        return formatter.format(cal.getTime());
    }

    public static String toCamelCase(String s){
        String[] parts = s.split("_");
        String camelCaseString = "";
        for (String part : parts){
            camelCaseString = camelCaseString + toProperCase(part);
        }
        return camelCaseString;
    }

    public static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }

}
