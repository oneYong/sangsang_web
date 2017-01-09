package com.web.sangsang.user.api;

import com.web.sangsang.cmm.entity.SsUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
}
