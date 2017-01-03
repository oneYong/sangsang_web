package com.web.sangsang.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by WYKIM on 2017-01-03.
 */
public interface SsGuideObjectMapper {
    @Select("SELECT * FROM sangsang.SS_GUIDE_OBJECT")
    public List<Map<String,Object>> select() throws Exception;
}
