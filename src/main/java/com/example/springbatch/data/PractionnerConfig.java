package com.example.springbatch.data;

import com.example.springbatch.model.Practionner;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class PractionnerConfig {
    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public ItemStreamReader<PractionnerInput> reader() {
        JdbcCursorItemReader<PractionnerInput> reader = new JdbcCursorItemReader<PractionnerInput>();
        reader.setDataSource(dataSource);
        reader.setSql("SELECT first_name, last_name FROM person");
        reader.setRowMapper(new PersonRowMapper());
        return reader;
    }

}
