package com.example.springbatch.data;

import com.example.springbatch.Config.Doqtoor_Admin_KPI_Config;
import com.example.springbatch.Config.Doqtoor_App_Config;
import com.example.springbatch.Models.doqtoor_app.PractionnerInput;
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
public class PractitionerConfig {
    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public ItemStreamReader<PractionnerInput> reader() {
        JdbcCursorItemReader<PractionnerInput> reader = new JdbcCursorItemReader<PractionnerInput>();
        reader.setDataSource(Doqtoor_App_Config.dataSourceAdmin);
        reader.setSql("SELECT * FROM practitioner_details");
        return reader;
    }

}
