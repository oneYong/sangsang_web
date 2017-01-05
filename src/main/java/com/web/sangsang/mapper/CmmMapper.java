package com.web.sangsang.mapper;

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

    @SelectProvider(type= CmmSqlProvider.class, method = "selectTable")
    public List<SsLogging> selectSsLogging(String tableName, String whereClause, Integer start, Integer end) throws Exception;

    @SelectProvider(type= CmmSqlProvider.class, method = "selectTable")
    public List<SsMuseum> selectSsMuseum(String tableName, String whereClause, Integer start, Integer end) throws Exception;
}
