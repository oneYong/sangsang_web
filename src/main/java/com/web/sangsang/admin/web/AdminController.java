package com.web.sangsang.admin.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.sangsang.cmm.entity.PageEntity;
import com.web.sangsang.cmm.entity.SsPlace;
import com.web.sangsang.mapper.CmmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kimwonyong on 2017. 1. 25..
 */
@Controller
@RequestMapping(value="/web/admin")
public class AdminController {
    @Autowired
    private CmmMapper cmmMapper;

    @RequestMapping(value="/viewPlace", method = RequestMethod.GET)
    public String viewPlace(){

        return "admin/viewPlace";
    }

    @RequestMapping(value = "/json/getPlaceInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getPlace(PageEntity pageEntity) throws Exception {
        Map<String, Object> returnData = new HashMap<String, Object>();

        String whereClause = pageEntity.getWhereClause();
        Integer start = pageEntity.getStart();
        Integer end = pageEntity.getEnd();

        List<Map<String,Object>> mapList = cmmMapper.selectTableList("SS_PLACE", whereClause, start, end);
        List<SsPlace> ssPlaceList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for(int i = 0; i < mapList.size(); i++){
            ssPlaceList.add(objectMapper.convertValue(mapList.get(i),SsPlace.class));
        }

        returnData.put("data",ssPlaceList);

        return returnData;

    }

}
