package com.springbatch.basicproject;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job printEvenOrOdd(){  // job is like a task
        return jobBuilderFactory
                .get("printEvenOrOdd")
                .start(printEvenOrOddJobStep()) // any job has step
                .incrementer(new RunIdIncrementer()) // creates a new instance job with a new parameter by execution and repetition. Note: if there is still conflict/cleaning the database, there is metadata. Attention: this feature prevents reuse of work
                .build();
    }

    public Step printEvenOrOddJobStep(){
        return stepBuilderFactory
                .get("printEvenOrOddStep")

                // <reade an Integer, write a String>chunk(sizeChunk)
                .<Integer, String>chunk(3)// 1 register by parte

                // reader() and writer() ever required, processor() is optional
                .reader(countUntilTenReader()) // receive a collection
                .processor(EvenOrOddProcessor()) // receive a item from collection by turn
                .writer(printWriter()) // receive the collection processed
                .build();
    }

    // ItemReader is the interface (default)
    // as a counter will be used and Springboot provides counter, it makes sense to use one from Springboot
    public IteratorItemReader<Integer> countUntilTenReader(){
        List<Integer> numberOneUntilTen = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new IteratorItemReader<Integer>(numberOneUntilTen.iterator());
    }

    // ItemProcessor is the interface (default)
    // In this case, the logic has the way like a function, then FunctionItemProcessor
    public FunctionItemProcessor<Integer, String> EvenOrOddProcessor(){
        return new FunctionItemProcessor<Integer, String>
                (item -> item % 2 == 0 ? String.format("Item %s is even", item) : String.format("Item %s is odd", item));
    }

   public ItemWriter<String> printWriter(){
        return itens -> itens.forEach(System.out::println);
   }
}
