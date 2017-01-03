package com.web.sangsang.framework.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wonyongkim on 2016. 12. 30..
 */
@Component
@Data
@ConfigurationProperties(prefix="Mybatis")
public class SsPropertyMybatis {
    private String configPath;
}
