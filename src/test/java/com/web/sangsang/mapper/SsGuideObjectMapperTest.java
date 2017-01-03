package com.web.sangsang.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by cloud4u on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SsGuideObjectMapperTest {
    @Autowired
    private SsGuideObjectMapper ssGuideObjectMapper;

    @Test
    public void selectTest() throws Exception{
        List<Map<String, Object>> list = ssGuideObjectMapper.select();
        System.out.println(list);
    }
}
