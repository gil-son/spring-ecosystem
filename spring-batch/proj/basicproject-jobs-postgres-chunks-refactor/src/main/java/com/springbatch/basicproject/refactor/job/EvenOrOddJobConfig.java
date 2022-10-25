package com.springbatch.basicproject.refactor.job;

import com.springbatch.basicproject.refactor.step.EvenOrOddStepConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class EvenOrOddJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job printEvenOrOdd(Step printEvenOrOddJobStep){  // job is like a task
        return jobBuilderFactory
                .get("printEvenOrOdd")
                .start(printEvenOrOddJobStep) // any job has step
                .incrementer(new RunIdIncrementer()) // creates a new instance job with a new parameter by execution and repetition. Note: if there is still conflict/cleaning the database, there is metadata. Attention: this feature prevents reuse of work
                .build();
    }
}
