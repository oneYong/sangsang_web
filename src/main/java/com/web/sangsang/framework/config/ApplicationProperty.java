package com.web.sangsang.framework.config;

import com.web.sangsang.framework.config.vo.DataSourceVO;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * Created by wonyongkim on 2016. 12. 30..
 */
@Component
@Data
@ConfigurationProperties(locations = {"application.yml"})
public class ApplicationProperty {
    @NestedConfigurationProperty
    public DataSourceVO dataSource = new DataSourceVO();

}
