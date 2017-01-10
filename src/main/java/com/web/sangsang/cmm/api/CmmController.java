package com.web.sangsang.cmm.api;

import com.web.sangsang.cmm.entity.PageEntity;
import com.web.sangsang.mapper.CmmMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by WYKIM on 2017-01-04.
 */
@RestController
@RequestMapping(value="/api/cmm")
@Api(value = "CmmController", description = "Common API")
public class CmmController {
    @Autowired
    private CmmMapper cmmMapper;

    @ApiOperation(value = "Get Table List Info")
    @RequestMapping(value="/{tableName}/list", method = {RequestMethod.POST, RequestMethod.GET})
    public List<Map<String,Object>> listTable(@PathVariable("tableName") String tablName, @RequestBody PageEntity pageEntity) throws Exception{
        String whereClause = pageEntity.getWhereClause();
        Integer start = pageEntity.getStart();
        Integer end = pageEntity.getEnd();

        return cmmMapper.selectTableList(tablName, whereClause, start, end);
    }

    @ApiOperation(value = "Get Table Info")
    @RequestMapping(value="/{tableName}/find", method = RequestMethod.GET)
    public Map<String,Object> findTable(@PathVariable("tableName") String tablName, @RequestParam("id") Long id) throws Exception{
        String whereClause = "ID = "+id;
        return cmmMapper.selectTable(tablName, whereClause);
    }
}
