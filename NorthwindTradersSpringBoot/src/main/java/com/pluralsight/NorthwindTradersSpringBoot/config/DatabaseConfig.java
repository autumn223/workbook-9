package com.pluralsight.NorthwindTradersSpringBoot.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    private BasicDataSource basicDataSource;

    public DatabaseConfig(@Value("${datasource.url}") String url,
                          @Value("${db.username}") String username,
                          @Value("${db.password}") String password) {

        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
    }

    @Bean
    public DataSource dataSource() {
        return basicDataSource;
    }
}



