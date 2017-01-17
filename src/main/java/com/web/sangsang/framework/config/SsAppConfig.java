package com.web.sangsang.framework.config;

import com.web.sangsang.cmm.util.CmmAES256Util;
import com.web.sangsang.framework.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.List;


/**
 * Created by WYKIM on 2017-01-04.
 */
@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan(basePackages = {"com.web.sangsang"}, useDefaultFilters = false,
        includeFilters = { @ComponentScan.Filter(Controller.class),
                @ComponentScan.Filter(ControllerAdvice.class),
                @ComponentScan.Filter(Repository.class),
                @ComponentScan.Filter(Component.class),
                @ComponentScan.Filter(Service.class)})
public class SsAppConfig extends WebMvcConfigurerAdapter {
    // AES256 key
    @Value("${aes256.key}")
    private String aes256Key;

    private static final String ERROR_CODE_PATH = "META-INF/error/error-code.xml";
    private static final String ERROR_MESSAGE_PATH = "META-INF/error/error-message_kr.xml";
    private static final String CONFIG_PATH = "META-INF/config/config.xml";


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .useJaf(true)
                .favorPathExtension(true)
                .favorParameter(false)
                .ignoreAcceptHeader(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json",MediaType.APPLICATION_JSON)
                .mediaType("xml",MediaType.APPLICATION_XML);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        return new MappingJackson2HttpMessageConverter();
    }

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();

        propertyPlaceholderConfigurer.setLocations(new Resource[]{
                new ClassPathResource(ERROR_CODE_PATH),
                new ClassPathResource(ERROR_MESSAGE_PATH),
                new ClassPathResource(CONFIG_PATH)});
        return propertyPlaceholderConfigurer;
    }

    @Bean
    public HandlerInterceptor tokenHandlerInterceptor() {
        return new TokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/**/swagger-*/**");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        HttpMessageConverter<String> stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(stringHttpMessageConverter);
    }

    @Bean
    public CmmAES256Util aes256CipherUtil() throws Exception {
        return new CmmAES256Util(aes256Key);
    }
}
