package com.web.sangsang.framework.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by WYKIM on 2017-01-03.
 */
@Configuration
public class SsServletConfig {

    @Bean
    public DispatcherServlet dispatcherServlet(){
        return new DispatcherServlet();
    }

    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
        final ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(), "/*");
        final Map<String, String> params = new HashMap<String, String>();
        params.put("contextClass", "org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
        params.put("contextConfigLocation", "com.web.sangsang");
        params.put("dispatchOptionsRequest", "true");
        registration.setInitParameters(params);

        registration.setLoadOnStartup(1);
        return registration;
    }
    /*
    @Bean
    public FilterRegistrationBean setCharacterEncodingFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(characterEncodingFilter());
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean setHiddenHttpMethodFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(hiddenHttpMethodFilter());
        bean.setOrder(1);
        return bean;
    }

    private CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    private HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("/*");
        return hiddenHttpMethodFilter;
    }
   */

}
