package com.web.sangsang.user.api;

import com.web.sangsang.SangsangWebApplication;
import com.web.sangsang.cmm.entity.SsUser;
import com.web.sangsang.framework.config.SsAppConfig;
import com.web.sangsang.framework.config.SsDataBaseConfig;
import com.web.sangsang.framework.config.SsServletConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by WYKIM on 2017-01-04.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    //@MockBean
    //private UserService userService;

    @Test
    public void test(){
        Map<String, Object> value = new HashMap<String,Object>();
        value.put("sourceType","123");
        value.put("sourceId","123");
        ResponseEntity<SsUser> returnVal = this.restTemplate.getForEntity("/api/user/find", SsUser.class, value);
        SsUser ssUser = returnVal.getBody();
        System.out.println(ssUser);
    }
}
