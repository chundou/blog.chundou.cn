package cn.chundou.blog.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${MYSQL_HOST}")
    private String host;

    @Value("${MYSQL_PORT}")
    private int port;

    @Value("${MYSQL_DB}")
    private String db;

    @Value("${MYSQL_USER}")
    private String user;

    @Value("${MYSQL_PASSWORD}")
    private String password;

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid.primary")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create()
                .build();
    }
}
