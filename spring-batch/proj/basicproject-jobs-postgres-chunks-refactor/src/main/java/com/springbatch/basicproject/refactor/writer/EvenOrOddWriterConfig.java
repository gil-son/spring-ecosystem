package com.springbatch.basicproject.refactor.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EvenOrOddWriterConfig {

    @Bean
    public ItemWriter<String> printWriter(){
        return itens -> itens.forEach(System.out::println);
    }

}
