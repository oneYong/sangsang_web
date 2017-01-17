package com.web.sangsang.cmm.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.sangsang.cmm.vo.CmmMessage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cloud4u on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CmmUtilTest {


    @Test
    public void test() throws Exception{

        System.out.println(CmmUtil.getCurrentDateSeoul());
        CmmMessage cmmMessage = new CmmMessage();
        cmmMessage.setMessage("kimwonyong");
        cmmMessage.setSuccessCount(7);

        String jsonStr = cmmMessage.toString();

        CmmMessage cmmMessage1 = CmmUtil.jsonStringToObject(jsonStr,CmmMessage.class);
        System.out.println(cmmMessage1.getMessage());
        System.out.println(cmmMessage1.getSuccessCount());

    }
}
