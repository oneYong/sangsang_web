package com.web.sangsang.mapper;

import com.web.sangsang.cmm.entity.SsUser;
import org.apache.ibatis.annotations.*;

/**
 * Created by WYKIM on 2017-01-03.
 */
public interface UserMapper {
    @Results(value = {
         @Result(property = "uid", column = "UID")
        ,@Result(property = "agreeTime", column = "AGREE_TIME")
        ,@Result(property = "createTime", column = "CREATE_TIME")
        ,@Result(property = "email", column = "EMAIL")
        ,@Result(property = "lastTime", column = "LAST_TIME")
        ,@Result(property = "leaveTime", column = "LEAVE_TIME")
        ,@Result(property = "name", column = "NAME")
        ,@Result(property = "birthYear", column = "BIRTH_YEAR")
        ,@Result(property = "interest", column = "INTEREST")
        ,@Result(property = "gender", column = "GENDER")
            ,@Result(property = "secessionType", column = "SECESSION_TYPE")
            ,@Result(property = "secessionOpinion", column = "SECESSION_OPINION")
        ,@Result(property = "source", column = "SOURCE")
        ,@Result(property = "sourceId", column = "SOURCE_ID")
        ,@Result(property = "sourceToken", column = "SOURCE_TOKEN")
    })

    @Select("SELECT * FROM sangsang.SS_USER WHERE SOURCE = #{source} AND SOURCE_ID = #{sourceId}")
    public SsUser selectUser(@Param("source") String source, @Param("sourceId")  String sourceId) throws Exception;

    @Insert("INSERT INTO sangsang.SS_USER (" +
            "  UID, AGREE_TIME, CREATE_TIME, EMAIL, LAST_TIME" +
            ", LEAVE_TIME, NAME, SOURCE, SOURCE_ID, SOURCE_TOKEN" +
            ", GENDER, BIRTH_YEAR,INTEREST) " +
            "  VALUES (" +
            "  #{uid},#{agreeTime},#{createTime},#{email},#{lastTime}" +
            " ,#{leaveTime},#{name},#{source},#{sourceId},#{sourceToken}" +
            " ,#{gender},#{birthYear},#{interest})")
    public int insertUser(SsUser ssUser) throws Exception;

    @Update("UPDATE sangsang.SS_USER " +
            "   SET UID = #{uid}" +
            "     , AGREE_TIME = #{agreeTime} " +
            "     , CREATE_TIME = #{createTime} " +
            "     , EMAIL = #{email} " +
            "     , LAST_TIME = #{lastTime} " +
            "     , LEAVE_TIME = #{leaveTime} " +
            "     , NAME = #{name} " +
            "     , SOURCE_TOKEN = #{sourceToken} " +
            "     , GENDER = #{gender} " +
            "     , BIRTH_YEAR = #{birthYear} " +
            "     , INTEREST = #{interest} " +
            "     , SECESSION_TYPE = #{secessionType} " +
            "     , SECESSION_OPINION = #{secessionOpinion} " +
            " WHERE SOURCE = #{source}" +
            "       AND SOURCE_ID = #{sourceId}")
    public int updateUser(SsUser ssUser) throws Exception;
}
