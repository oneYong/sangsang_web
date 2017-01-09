package com.web.sangsang.cmm.api;

import com.web.sangsang.cmm.entity.BaseEntity;
import com.web.sangsang.cmm.entity.PageEntity;
import com.web.sangsang.cmm.entity.SsMuseum;
import com.web.sangsang.cmm.entity.SsUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by WYKIM on 2017-01-04.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CmmControllerTest {

    //@MockBean
    //private UserService userService;

    @Test
    public void testGetTableList(){
        RestTemplate restTemplate = new RestTemplate();
        URI uri = URI.create("http://localhost:8077/api/cmm/SS_MUSEUM/list");
        PageEntity pageEntity = new PageEntity();
        pageEntity.setStart(1);
        pageEntity.setEnd(10);

        List<BaseEntity> resultBaseEntity = Arrays.asList(restTemplate.postForObject(uri,pageEntity,SsMuseum[].class));

        // solution 1
        List<SsMuseum> ssMuseumList = (List<SsMuseum>)(Object) resultBaseEntity;
        System.out.println(ssMuseumList);

        // solution 2
        List<SsMuseum> ssMuseumList2 = resultBaseEntity.stream()
                .map(element->(SsMuseum) element)
                .collect(Collectors.toList());
        System.out.println(ssMuseumList2);

    }

    @Test
    public void testGetTable(){
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8077/api/cmm/SS_MUSEUM/find")
                .queryParam("id","538")
                .build().toUri();

        SsMuseum ssMuseum = restTemplate.getForObject(uri,SsMuseum.class);
        System.out.println(ssMuseum);


    }
}
