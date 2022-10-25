package com.springbatch.basicproject.refactor.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EvenOrOddStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step printEvenOrOddJobStep(IteratorItemReader<Integer> countUntilTenReader,
                                      FunctionItemProcessor<Integer,
                                              String> evenOrOddProcessor, ItemWriter<String> printWriter){
        return stepBuilderFactory
                .get("printEvenOrOddStep")

                // <reade an Integer, write a String>chunk(sizeChunk)
                .<Integer, String>chunk(3)// 1 register by parte

                // reader() and writer() ever required, processor() is optional
                .reader(countUntilTenReader) // receive a collection
                .processor(evenOrOddProcessor) // receive a item from collection by turn
                .writer(printWriter) // receive the collection processed
                .build();
    }
}
