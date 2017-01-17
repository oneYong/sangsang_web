package com.web.sangsang.framework.interceptor;

import com.web.sangsang.cmm.service.TokenService;
import com.web.sangsang.framework.exceptions.EmptyTokenException;
import com.web.sangsang.framework.exceptions.NotExistUserException;
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
    @Autowired
    private NotExistUserException notExistUserException;

    @Autowired
    private TokenService tokenService;

    private static final String TOKEN_NAME = "x-auth-token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. check empty token
        String xAuthToken = checkEmptyToken(request);

        // 2. check exist user
        checkExistUser(xAuthToken);

        return true;
    }

        private void checkExistUser(String xAuthToken) throws Exception {
            if(!tokenService.isExistUser(xAuthToken))
                throw notExistUserException;
        }

        private String checkEmptyToken(HttpServletRequest request) throws Exception{
            String xAuthToken = null;
            try {
                xAuthToken = request.getHeader(TOKEN_NAME);
            } catch(NullPointerException npe) {
                throw emptyTokenException;
            } finally {
                if(xAuthToken == null) throw emptyTokenException;
            }
            return xAuthToken;
        }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
