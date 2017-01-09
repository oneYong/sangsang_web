package com.web.sangsang.mapper;

import com.web.sangsang.cmm.entity.SsUser;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by WYKIM on 2017-01-03.
 */
public interface UserMapper {
    @Results(value = {
         @Result(property = "guid", column = "GUID")
        ,@Result(property = "agreeTime", column = "AGREE_TIME")
        ,@Result(property = "createTime", column = "CREATE_TIME")
        ,@Result(property = "email", column = "EMAIL")
        ,@Result(property = "lastTime", column = "LAST_TIME")
        ,@Result(property = "leaveTime", column = "LEAVE_TIME")
        ,@Result(property = "name", column = "NAME")
        ,@Result(property = "birthYear", column = "BIRTH_YEAR")
        ,@Result(property = "gender", column = "GENDER")
        ,@Result(property = "source", column = "SOURCE")
        ,@Result(property = "sourceId", column = "SOURCE_ID")
        ,@Result(property = "sourceToken", column = "SOURCE_TOKEN")
    })
    @Select("SELECT * FROM sangsang.SS_USER")
    public SsUser selectUser(String source, String sourceId) throws Exception;
}
