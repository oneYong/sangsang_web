package com.web.sangsang.mapper;


import com.web.sangsang.cmm.entity.SsLogging;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by cloud4u on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Rollback(value=true)
public class LoggingMapperTest {
    @Autowired
    private LoggingMapper loggingMapper;

    @Autowired
    private CmmMapper cmmMapper;

    private SsLogging ssLogging;
    @Before
    public void init(){
        ssLogging = new SsLogging();
        ssLogging.setType("testType");
        ssLogging.setRecodeTime(new Date());
        ssLogging.setAccessInfo("access info");
        ssLogging.setAccessIp("123.123.123.123");
        ssLogging.setReferer("referer");
        ssLogging.setUserId("iersans");
        ssLogging.setUserName("test");
    }

    @Test
    public void testInsertLogging() throws Exception{
        loggingMapper.insertLogging(ssLogging);

        List<Map<String, Object>> loggingList = cmmMapper.selectTableList("SS_LOGGING","",null,null);
        System.out.println(loggingList);
    }

}
