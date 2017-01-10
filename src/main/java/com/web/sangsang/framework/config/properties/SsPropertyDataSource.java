package com.web.sangsang.framework.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wonyongkim on 2016. 12. 30..
 */
@Component
@Data
@ConfigurationProperties(locations={"application-datasource.yml"},prefix="DataSource")
public class SsPropertyDataSource {
    private String driverClassName;
    private String url;
    private String userName;
    private String password;

}
