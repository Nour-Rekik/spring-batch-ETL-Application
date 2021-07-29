package com.example.springbatch.Config;

import com.example.springbatch.Models.doqtoor_app.*;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "appEntityManagerFactory", basePackages = {
        "com.example.springbatch.Repositories.doqtoor_app"}, transactionManagerRef = "appTransactionManager")
public class Doqtoor_App_Config {

    public static DataSource dataSourceAdmin;


    @Bean
    @ConfigurationProperties("app.datasource2")
    public DataSourceProperties appDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    @ConfigurationProperties("app.datasource2.configuration")
    public DataSource appDataSource() {
        dataSourceAdmin= appDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
        return dataSourceAdmin;
    }

    @Bean(name = "appEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean appEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(appDataSource())
                .packages(Patient.class, AbstractAuditingEntity.class, Authority.class, PractitionerInput.class, UploadedFilesRegistration.class, User.class , UserInfoDetails.class)
                .build();
    }
    @Bean
    public PlatformTransactionManager appTransactionManager(
            final @Qualifier("appEntityManagerFactory") LocalContainerEntityManagerFactoryBean appEntityManagerFactory) {
        return new JpaTransactionManager(appEntityManagerFactory.getObject());
    }
}
