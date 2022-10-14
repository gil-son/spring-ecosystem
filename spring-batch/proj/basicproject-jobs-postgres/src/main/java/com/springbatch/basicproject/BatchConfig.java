package com.springbatch.basicproject;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job printHelloJob(){  // job is like a task
        return jobBuilderFactory
                .get("printHelloJob")
                .start(printHelloJobStep()) // any job has step
                .incrementer(new RunIdIncrementer()) // creates a new instance job with a new parameter by execution and repetition. Note: if there is still conflict/cleaning the database, there is metadata. Attention: this feature prevents reuse of work
                .build();
    }

    public Step printHelloJobStep(){
        return stepBuilderFactory
                .get("printHelloStep")
                .tasklet(new Tasklet() { // simples tasks
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("Hello World");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }

}
