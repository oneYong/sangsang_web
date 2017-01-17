package com.web.sangsang.logging.service;


import com.web.sangsang.cmm.entity.SsLogging;
import com.web.sangsang.cmm.vo.CmmException;
import com.web.sangsang.cmm.vo.CmmMessage;
import com.web.sangsang.mapper.CmmMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cloud4u on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Rollback(value=true)
public class LoggingServiceTest {
    @Autowired
    private LoggingService loggingService;

    @Autowired
    private CmmMapper cmmMapper;


    private List<SsLogging> getLoggingLIst() {
        List<SsLogging> ssLoggingList = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            SsLogging ssLogging = new SsLogging();
            ssLogging.setType("testType");
            ssLogging.setRecodeTime(new Date());
            ssLogging.setAccessInfo("access info");
            ssLogging.setAccessIp("123.123.123.123");
            ssLogging.setReferer("referer");
            ssLogging.setUserId("iersanssdfsf" + i);
            ssLogging.setUserName("test");

            ssLoggingList.add(ssLogging);
        }

        return ssLoggingList;
    }

    @Test
    public void testPushLogging() {
        List<SsLogging> ssLoggingList = getLoggingLIst();
        CmmMessage result = null;
        try{
            result = (CmmMessage) loggingService.pushLogging(ssLoggingList);
        }catch (Exception e){
            CmmException cmmException = (CmmException) e;
            result = ((CmmException) e).getCmmMessage();
        }

        System.out.println(result);
    }




}
