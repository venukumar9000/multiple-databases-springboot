package com.example.mds.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.mds.orderRepository",
        entityManagerFactoryRef = "postgresqlEntityManagerFactory",
        transactionManagerRef = "postgresqlTransactionManager"
)
public class PostgresqlJpaConfiguration {

    @Bean(name = "postgresqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactoryBean (
            EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            @Qualifier("postgresqlDataSource") DataSource dataSource) {
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.example.mds.orderentity")
                .build();
    }
    @Bean(name = "postgresqlTransactionManager")
    PlatformTransactionManager postgresqlTransactionManager(@Qualifier("postgresqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean efm){
        return new JpaTransactionManager(Objects.requireNonNull(efm.getObject()));
    }
}
