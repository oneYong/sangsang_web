package com.web.sangsang.logging.service;

import com.web.sangsang.cmm.entity.SsLogging;
import com.web.sangsang.framework.annotation.AfterSaving;
import com.web.sangsang.mapper.LoggingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by WYKIM on 2017-01-09.
 */
@Service
public class LoggingService {
    @Autowired
    private LoggingMapper loggingMapper;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @AfterSaving
    public Object pushLogging(List<SsLogging> ssLoggingList) throws Exception {
        for(SsLogging ssLogging: ssLoggingList){
            loggingMapper.insertLogging(ssLogging);
        }
        return ssLoggingList.size();
    }
}
