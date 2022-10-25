package com.springbatch.basicproject.refactor.reader;

import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class EvenOrOddReaderConfig {

    // ItemReader is the interface (default) and has in your implementation IteratorItemReader
    // as a counter will be used and Springboot provides counter, it makes sense to use one from Springboot
    @Bean
    public IteratorItemReader<Integer> countUntilTenReader(){
        List<Integer> numberOneUntilTen = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new IteratorItemReader<Integer>(numberOneUntilTen.iterator());
    }
}
