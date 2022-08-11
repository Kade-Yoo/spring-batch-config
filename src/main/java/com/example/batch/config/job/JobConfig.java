package com.example.batch.config.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class JobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job printJob() {
        return jobBuilderFactory.get("printJob")
                .start(printStep1())
                .build();
    }

    @Bean
    public Step printStep1() {
        return stepBuilderFactory.get("printStep1")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Step1");
                    return RepeatStatus.FINISHED;
                }).build();
    }
}