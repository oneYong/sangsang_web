package com.web.sangsang.mapper;


import com.web.sangsang.cmm.entity.SsUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by cloud4u on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Rollback(value=true)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    private SsUser ssUser;
    @Before
    public void init(){
        ssUser = new SsUser();
        ssUser.setGuid("123-123-123");
        ssUser.setName("테스트");
        ssUser.setCreateTime(new Date());
        ssUser.setEmail("iersans@naver.com");
        ssUser.setSource("NAVER");
        ssUser.setSourceId("123123123");
    }


    @Test
    public void testSelectUser() throws Exception{
        String source = "FACEBOOK";
        String sourceId = "100200034";
        SsUser ssUser = userMapper.selectUser(source,sourceId);
        System.out.println(ssUser);
    }

    @Test
    public void testInsertUser() throws Exception{
        userMapper.insertUser(ssUser);
        System.out.println(userMapper.selectUser(ssUser.getSource(),ssUser.getSourceId()));
    }

    @Test
    public void testUpdatetUser() throws Exception{
        userMapper.insertUser(ssUser);
        SsUser temp = userMapper.selectUser(ssUser.getSource(),ssUser.getSourceId());
        temp.setEmail("kimwy@neutti.com");

        userMapper.updateUser(temp);

        System.out.println(userMapper.selectUser(temp.getSource(),temp.getSourceId()));
    }

}
