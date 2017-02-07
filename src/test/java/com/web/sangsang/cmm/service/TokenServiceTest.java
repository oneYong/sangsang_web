package com.web.sangsang.cmm.service;



import com.web.sangsang.cmm.util.CmmUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by cloud4u on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Rollback(value=true)
public class TokenServiceTest {
    @Autowired
    private TokenService tokenService;

    private MakeTokenInfo makeTokenInfo;

    @Before
    public void init(){
        makeTokenInfo = new MakeTokenInfo();
        makeTokenInfo.setSource("FACEBOOK");
        makeTokenInfo.setSourceId("1707234592927236");
        makeTokenInfo.setName("박찬신");
        makeTokenInfo.setCurrentTime(CmmUtil.getCurrentDateSeoul());
    }

    @Test
    public void testCreateToken() throws Exception{
        System.out.println(tokenService.createToken(makeTokenInfo));
    }

    @Test
    public void testIsExistUser() throws  Exception{
        System.out.println("User info is ... "+tokenService.isExistUser("1f+5XDFjhYoiK7R3h7v3f8ywDBVBEDkfwCsYMJ24qGz3oZdA/NP84V66wE/6HgsSE5WZuQrD5REcee+j5b67RIbyhyyYaYL2nDAw075ex4OtU7jmfxJiAvKsZTsSS/mBcopLeTo/NoVhYdW+kiYgqQ=="));
    }

}
