package com.springbatch.basicproject.refactor.processor;

import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EvenOrOddProcessorConfig {

    // ItemProcessor is the interface (default)
    // In this case, the logic has the way like a function, then FunctionItemProcessor

    @Bean
    public FunctionItemProcessor<Integer, String> evenOrOddProcessor(){
        return new FunctionItemProcessor<Integer, String>
                (item -> item % 2 == 0 ? String.format("Item %s is even", item) : String.format("Item %s is odd", item));
    }

}
