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
public class CmmAES256UtilTest {

    private CmmAES256Util cmmAES256Util;

    @Before
    public void init() throws Exception{
        cmmAES256Util = new CmmAES256Util("sangsang-web-rest-api");
    }

    @Test
    public void testEncodeDecode() throws Exception{
        CmmMessage cmmMessage = new CmmMessage();
        cmmMessage.setMessage("hello");
        cmmMessage.setSuccessCount(7);
        String result = cmmMessage.toString();

        String encodeStr = cmmAES256Util.aesEncode(result);
        System.out.println(encodeStr);


        ObjectMapper mapper = new ObjectMapper();
        String decodeStr = cmmAES256Util.aesDecode(encodeStr);
        CmmMessage cmmMessage1 = mapper.readValue(decodeStr,CmmMessage.class);

        System.out.println("String is ... " +decodeStr);
        System.out.println("CmmMessage is ... " +cmmMessage1);

    }
}
