package com.web.sangsang.mapper;


import com.web.sangsang.cmm.entity.SsUser;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;


    @Test
    public void testSelectTable() throws Exception{
        String source = "FACEBOOK";
        String sourceId = "100200034";
        SsUser ssUser = userMapper.selectUser(source,sourceId);
        System.out.println(ssUser);
    }

}
