package com.web.sangsang.logging.api;

import com.web.sangsang.cmm.entity.BaseEntity;
import com.web.sangsang.cmm.entity.SsLogging;
import com.web.sangsang.cmm.entity.SsUser;
import com.web.sangsang.cmm.util.CmmException;
import com.web.sangsang.cmm.util.CmmMessage;
import com.web.sangsang.logging.service.LoggingService;
import com.web.sangsang.mapper.UserMapper;
import com.web.sangsang.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by WYKIM on 2017-01-04.
 */
@RestController
@RequestMapping(value="/api/logging")
@Api(value = "LoggingController", description = "Logging API")
public class LoggingController {
    @Autowired
    private LoggingService loggingService;

    @ApiOperation(value = "Push History Logging Info")
    @RequestMapping(value="/push", method = RequestMethod.POST)
    public BaseEntity pushLogging(@RequestBody List<SsLogging> loggingList) throws Exception{
        CmmMessage result = null;
        BaseEntity baseEntity = new BaseEntity();

        try{
            result = (CmmMessage) loggingService.pushLogging(loggingList);
        }catch (Exception e){
            CmmException cmmException = (CmmException) e;
            result = ((CmmException) e).getCmmMessage();
        }finally {
            baseEntity.setResult(result.toString());
        }

        return baseEntity;
    }
}
