package com.web.sangsang.mapper;


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
        List<SsLogging> list = cmmMapper.selectSsLogging("sangsang.SS_LOGGING","",1,10);
        System.out.println(list);

        List<SsMuseum> list2 = cmmMapper.selectSsMuseum("sangsang.SS_MUSEUM","",1,10);
        System.out.println(list2);
    }
}
