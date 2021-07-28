package com.example.springbatch.Config;

import com.example.springbatch.Models.doqtoor_admin_kpi.Person;
import com.example.springbatch.Models.doqtoor_admin_kpi.Practitioner;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "kpiEntityManagerFactory", basePackages = {
    "com.example.springbatch.Repositories.doqtoor_admin_kpi"}, transactionManagerRef = "kpiTransactionManager")
public class Doqtoor_Admin_KPI_Config {

    public static DataSource dataSourceAdmin;

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource1")
    public DataSourceProperties kpiDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource1.configuration")
    public DataSource kpiDataSource() {
        dataSourceAdmin= kpiDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
        return dataSourceAdmin;
    }

    @Primary
    @Bean(name = "kpiEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean kpiEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(kpiDataSource())
                .packages(Practitioner.class, Person.class)
                .build();
    }
    @Primary
    @Bean
    public PlatformTransactionManager kpiTransactionManager(
            final @Qualifier("kpiEntityManagerFactory") LocalContainerEntityManagerFactoryBean kpiEntityManagerFactory) {
        return new JpaTransactionManager(kpiEntityManagerFactory.getObject());
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.primaryliquibase.liquibase")
    public LiquibaseProperties primaryLiquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean
    public SpringLiquibase primaryLiquibase() {
        return springLiquibase(kpiDataSource(), primaryLiquibaseProperties());
    }

    private static SpringLiquibase springLiquibase(DataSource dataSource, LiquibaseProperties properties) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(properties.getChangeLog());
        System.out.println(liquibase.getChangeLog());
        liquibase.setContexts(properties.getContexts());
        liquibase.setDefaultSchema(properties.getDefaultSchema());
        liquibase.setDropFirst(properties.isDropFirst());
        liquibase.setShouldRun(properties.isEnabled());
        liquibase.setLabels(properties.getLabels());
        liquibase.setChangeLogParameters(properties.getParameters());
        liquibase.setRollbackFile(properties.getRollbackFile());
        return liquibase;
    }

}
