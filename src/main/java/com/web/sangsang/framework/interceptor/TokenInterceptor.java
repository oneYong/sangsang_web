package com.web.sangsang.framework.interceptor;

import com.web.sangsang.framework.exceptions.EmptyTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by WYKIM on 2017-01-16.
 */
public class TokenInterceptor implements HandlerInterceptor{
    @Autowired
    private EmptyTokenException emptyTokenException;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = null;
        try {
            token = request.getHeader("x-auth-token").toString();
        } catch(NullPointerException npe) {
            throw emptyTokenException;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
