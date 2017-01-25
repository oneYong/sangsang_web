package com.web.sangsang.test.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.sangsang.test.json.vo.ExtendableBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by WYKIM on 2017-01-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class JsonAnnotationTest {

    @Test
    public void test() throws JsonProcessingException {
        ExtendableBean extendableBean = new ExtendableBean("MyName");
        extendableBean.add("att1","val1");
        extendableBean.add("att2","val2");

        String result = new ObjectMapper().writeValueAsString(extendableBean);
        System.out.println(result);
    }

}
