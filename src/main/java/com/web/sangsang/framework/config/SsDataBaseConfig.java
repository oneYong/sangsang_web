package com.web.sangsang.framework.config;

import com.web.sangsang.framework.config.properties.SsPropertyDataSource;
import com.web.sangsang.framework.config.properties.SsPropertyMybatis;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * Created by WYKIM on 2017-01-03.
 */
@Configuration
@EnableTransactionManagement
@Lazy
@MapperScan("com.web.sangsang.mapper")
public class SsDataBaseConfig implements TransactionManagementConfigurer {

    @Autowired
    private SsPropertyDataSource ssPropertyDataSource;
    @Autowired
    private SsPropertyMybatis ssPropertyMybatis;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        String driverClassName = ssPropertyDataSource.getDriverClassName();
        String url = ssPropertyDataSource.getUrl();
        String username = ssPropertyDataSource.getUserName();
        String password = ssPropertyDataSource.getPassword();

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        String mybatisConfigPath = ssPropertyMybatis.getConfigPath();

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfigLocation(new ClassPathResource(mybatisConfigPath));
        return bean.getObject();
    }

    @Bean(destroyMethod = "clearCache")
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
