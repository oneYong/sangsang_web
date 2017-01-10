package com.web.sangsang.user.api;

import com.web.sangsang.cmm.entity.SsUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Date;


/**
 * Created by WYKIM on 2017-01-04.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerTest {

    //@MockBean
    //private UserService userService;

    @Test
    public void testFindUser(){
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8077/api/user/find")
                .queryParam("source","FACEBOOK")
                .queryParam("sourceId","100200034")
                .build().toUri();

        SsUser ssUser = restTemplate.getForObject(uri, SsUser.class);
        System.out.println(ssUser);
    }

    private SsUser getNewUser(){
        SsUser ssUser = new SsUser();
        ssUser.setGuid("123-456-789-1234");
        ssUser.setName("인서트 유저");
        ssUser.setCreateTime(new Date());
        ssUser.setEmail("iersans@123.com");
        ssUser.setSource("FACEBOOK");
        ssUser.setSourceId("123412341234");
        return ssUser;
    }

    @Test
    public void testUpdateUser(){
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8077/api/user/find")
                .queryParam("source","FACEBOOK")
                .queryParam("sourceId","100200034")
                .build().toUri();

        SsUser paramUser = restTemplate.getForObject(uri, SsUser.class);
        paramUser.setEmail("neutti@neutti.com");


        uri = URI.create("http://localhost:8077/api/user/update");
        SsUser ssUser = restTemplate.postForObject(uri,paramUser,SsUser.class);

        System.out.println(ssUser);
    }

    @Test
    public void testInsertUser(){
        RestTemplate restTemplate = new RestTemplate();
        URI uri = URI.create("http://localhost:8077/api/user/update");
        SsUser paramUser = getNewUser();

        SsUser ssUser = restTemplate.postForObject(uri,paramUser,SsUser.class);

        System.out.println(ssUser);
    }
}
