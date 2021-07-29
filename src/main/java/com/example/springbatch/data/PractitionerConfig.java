package com.example.springbatch.data;

import com.example.springbatch.Config.Doqtoor_Admin_KPI_Config;
import com.example.springbatch.Config.Doqtoor_App_Config;
import com.example.springbatch.Models.doqtoor_admin_kpi.Practitioner;
import com.example.springbatch.Models.doqtoor_app.PractitionerInput;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
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
    @Autowired
    private Doqtoor_App_Config source1;

    @Autowired
    private Doqtoor_Admin_KPI_Config source2;

    @Bean
    public ItemStreamReader<PractitionerInput> reader() {
        JdbcCursorItemReader<PractitionerInput> reader = new JdbcCursorItemReader<PractitionerInput>();
        reader.setDataSource(source1.dataSourceAdmin);
        reader.setRowMapper(new PractitionerRowMapper());
        reader.setSql("SELECT * FROM practitioner_details");
        return reader;
    }

    @Bean
    public PractitionerDataProcessor processor() {
        return new PractitionerDataProcessor();
    }

    @Bean
    public ItemWriter<Practitioner> writer() {
        JdbcBatchItemWriter<Practitioner> writer = new JdbcBatchItemWriter<Practitioner>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Practitioner>());
        writer.setSql("INSERT INTO Practitioner (RegionExercise, Rib, taxRegistrationNumber) VALUES (:RegionExercise, :Rib, :taxRegistrationNumber)");
        writer.setDataSource(source2.dataSourceAdmin);
        return writer;
    }

    @Bean
    public Job importUserJob() {
        return jobs.get("databaseToDatabaseJob")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return steps.get("databaseToDatabaseStep")
                .<PractitionerInput, Practitioner> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

}
