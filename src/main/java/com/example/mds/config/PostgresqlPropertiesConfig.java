package com.example.mds.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PostgresqlPropertiesConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.pg")
    public DataSourceProperties postgresqlProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource postgresqlDataSource(){


        return postgresqlProperties().initializeDataSourceBuilder().build();
    }
}
