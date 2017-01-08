package com.web.sangsang.mapper;

import com.web.sangsang.cmm.entity.BaseEntity;
import com.web.sangsang.cmm.entity.SsLogging;
import com.web.sangsang.cmm.entity.SsMuseum;
import com.web.sangsang.cmm.util.CmmSqlProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * Created by WYKIM on 2017-01-03.
 */
public interface CmmMapper{

    @SelectProvider(type= CmmSqlProvider.class, method = "selectTableList")
    public List<Map<String,Object>> selectTableList(String tableName, String whereClause, Integer start, Integer end) throws Exception;
}
