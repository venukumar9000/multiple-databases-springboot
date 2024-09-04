package com.example.mds.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MySqlDatasourceConfig {

    @ConfigurationProperties("spring.datasource.mysql")
    @Bean
    @Primary
    public DataSourceProperties mySqlDatasourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource mysqlDatasource(){


        return mySqlDatasourceProperties().initializeDataSourceBuilder().build();
    }

}
