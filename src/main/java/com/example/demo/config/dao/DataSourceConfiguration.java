package com.example.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * Created by wangzhenqin on 2019/7/19.
 */
@Configuration
@MapperScan("com.example.demo.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUserName;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean("dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        //关闭连接后不自动commit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
