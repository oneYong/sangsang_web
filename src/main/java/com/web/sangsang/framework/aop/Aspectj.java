package com.web.sangsang.framework.aop;

import com.web.sangsang.cmm.util.CmmException;
import com.web.sangsang.cmm.util.CmmMessage;
import com.web.sangsang.framework.annotation.AfterSaving;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by WYKIM on 2017-01-10.
 */
@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class Aspectj {

    @Around("@annotation(afterSaving)")
    public Object aroundAfterSaveInfo(final ProceedingJoinPoint joinPoint, final AfterSaving afterSaving) throws Exception{
        CmmMessage cmmMessage = new CmmMessage();

        try{
            Object result = joinPoint.proceed();

            cmmMessage.setSuccessCount((Integer)result);
            cmmMessage.setMessage("SUCCESS");
        }catch (Throwable e){

            cmmMessage.setMessage(e.getMessage());
            cmmMessage.setSuccessCount(0);

            CmmException cmmException = new CmmException(e.getMessage());
            cmmException.setCmmMessage(cmmMessage);
            throw cmmException;
        }

        return cmmMessage;
    }


}
