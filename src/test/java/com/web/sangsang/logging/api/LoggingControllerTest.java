package com.web.sangsang.logging.api;

import com.web.sangsang.cmm.entity.BaseEntity;
import com.web.sangsang.cmm.entity.SsLogging;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by WYKIM on 2017-01-04.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LoggingControllerTest {

    private List<SsLogging> getLoggingLIst() {
        List<SsLogging> ssLoggingList = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            SsLogging ssLogging = new SsLogging();
            ssLogging.setType("testType");
            ssLogging.setRecodeTime(new Date());
            ssLogging.setAccessInfo("access info");
            ssLogging.setAccessIp("123.123.123.123");
            ssLogging.setReferer("referer");
            ssLogging.setUserId("iersans" + (i+1));
            ssLogging.setUserName("test");

            ssLoggingList.add(ssLogging);
        }

        return ssLoggingList;
    }

    @Test
    public void testPushLogging(){
        RestTemplate restTemplate = new RestTemplate();
        URI uri = URI.create("http://localhost:8077/api/logging/push");
        List<SsLogging> paramLoggingList = getLoggingLIst();

        BaseEntity baseEntity = restTemplate.postForObject(uri,paramLoggingList,BaseEntity.class);

        System.out.println(baseEntity);
    }
}
