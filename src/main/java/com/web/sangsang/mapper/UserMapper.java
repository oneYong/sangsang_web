package com.web.sangsang.mapper;

import com.web.sangsang.cmm.entity.SsUser;
import org.apache.ibatis.annotations.*;

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

    @Select("SELECT * FROM sangsang.SS_USER WHERE SOURCE = #{source} AND SOURCE_ID = #{sourceId}")
    public SsUser selectUser(@Param("source") String source, @Param("sourceId")  String sourceId) throws Exception;

    @Insert("INSERT INTO sangsang.SS_USER (" +
            "  GUID, AGREE_TIME, CREATE_TIME, EMAIL, LAST_TIME" +
            ", LEAVE_TIME, NAME, SOURCE, SOURCE_ID, SOURCE_TOKEN" +
            ", GENDER, BIRTH_YEAR) " +
            "  VALUES (" +
            "  #{guid},#{agreeTime},#{createTime},#{email},#{lastTime}" +
            " ,#{leaveTime},#{name},#{source},#{sourceId},#{sourceToken}" +
            " ,#{gender},#{birthYear})")
    public int insertUser(SsUser ssUser) throws Exception;

    @Update("UPDATE sangsang.SS_USER " +
            "   SET AGREE_TIME = #{agreeTime} " +
            "     , CREATE_TIME = #{createTime} " +
            "     , EMAIL = #{email} " +
            "     , LAST_TIME = #{lastTime} " +
            "     , LEAVE_TIME = #{leaveTime} " +
            "     , NAME = #{name} " +
            "     , SOURCE = #{source} " +
            "     , SOURCE_ID = #{sourceId} " +
            "     , SOURCE_TOKEN = #{sourceToken} " +
            "     , GENDER = #{gender} " +
            "     , BIRTH_YEAR = #{birthYear} " +
            " WHERE GUID = #{guid}")
    public int updateUser(SsUser ssUser) throws Exception;
}
