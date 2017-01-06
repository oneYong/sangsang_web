package com.web.sangsang.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.sangsang.cmm.entity.BaseEntity;
import com.web.sangsang.cmm.entity.SsGuide;
import com.web.sangsang.cmm.entity.SsLogging;
import com.web.sangsang.cmm.entity.SsMuseum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.java2d.cmm.kcms.CMM;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by cloud4u on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CmmMapperTest {
    @Autowired
    private CmmMapper cmmMapper;

    @Test
    public void selectTest() throws Exception{
        List<Map<String,Object>> list = cmmMapper.selectTableList("SS_OBJECT","",1,10);
        System.out.println(list);
    }

}
