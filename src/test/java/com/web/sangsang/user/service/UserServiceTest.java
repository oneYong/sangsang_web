package com.web.sangsang.user.service;


import com.web.sangsang.cmm.entity.SsUser;
import com.web.sangsang.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by cloud4u on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Rollback(value=true)
public class UserServiceTest {
    @Autowired
    private UserService userservice;

    @Autowired
    private UserMapper userMapper;

    private SsUser getUser() throws Exception{
        String source = "NAVER";
        String sourceId = "123123123";
        SsUser ssUser = userMapper.selectUser(source, sourceId);
        return ssUser;
    }

    private SsUser getNewUser() {

        SsUser ssUser = new SsUser();
        ssUser.setUid("123-456-789");
        ssUser.setName("인서트");
        ssUser.setCreateTime(new Date());
        ssUser.setEmail("iersans@123.com");
        ssUser.setSource("FACEBOOK");
        ssUser.setSourceId("11023013134");
        return ssUser;
    }

    @Test
    public void testUpdateRegisterUser() throws Exception{
        SsUser ssUser = getUser();
        ssUser.setAgreeTime(new Date());
        SsUser resultUser = userservice.registerUser(ssUser);

        System.out.println(resultUser);
    }

    @Test
    public void testInsertRegisterUser() throws Exception{
        SsUser ssUser = getNewUser();
        SsUser resultUser = userservice.registerUser(ssUser);

        System.out.println(resultUser);
    }


}
