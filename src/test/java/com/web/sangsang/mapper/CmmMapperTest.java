package com.web.sangsang.mapper;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.Map;

/**
 * Created by cloud4u on 2016-04-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CmmMapperTest {
    @Autowired
    private CmmMapper cmmMapper;

    @Test
    public void testListTable() throws Exception{
        List<Map<String,Object>> list = cmmMapper.selectTableList("SS_OBJECT","",1,10);
        System.out.println(list);
    }

    @Test
    public void testFindTable() throws Exception{
        Long id = 538L;
        String whereClause = "ID = " +id;
        Map<String,Object> ssMuseum = cmmMapper.selectTable("SS_MUSEUM",whereClause);
        System.out.println(ssMuseum);
    }

}
