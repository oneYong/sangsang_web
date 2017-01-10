package com.web.sangsang.mapper;

import com.web.sangsang.cmm.entity.SsLogging;
import org.apache.ibatis.annotations.*;

/**
 * Created by WYKIM on 2017-01-03.
 */
public interface LoggingMapper {
    @Results(value = {
         @Result(property = "type", column = "TYPE")
        ,@Result(property = "recodeTime", column = "RECODE_TIME")
        ,@Result(property = "referer", column = "REFERER")
        ,@Result(property = "accessIp", column = "ACCESS_IP")
        ,@Result(property = "accessInfo", column = "ACCESS_INFO")
        ,@Result(property = "userId", column = "USER_ID")
        ,@Result(property = "userName", column = "USER_NAME")
    })

    @Insert("INSERT INTO sangsang.SS_LOGGING (" +
            "  TYPE, RECODE_TIME, REFERER, ACCESS_IP, ACCESS_INFO" +
            ", USER_ID, USER_NAME ) " +
            "  VALUES (" +
            "  #{type},#{recodeTime},#{referer},#{accessIp},#{accessInfo}" +
            " ,#{userId},#{userName})")
    public int insertLogging(SsLogging ssLogging) throws Exception;


}
