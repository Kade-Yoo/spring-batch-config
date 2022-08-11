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
public class StepNextJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job stepNextJob() {
        return jobBuilderFactory.get("stepNextJob")
                .start(printNextStep1())
                .next(printNextStep2())
                .next(printNextStep3())
                .build();
    }

    @Bean
    public Step printNextStep1() {
        return stepBuilderFactory.get("printNextStep1")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Step1");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step printNextStep2() {
        return stepBuilderFactory.get("printNextStep2")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Step2");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step printNextStep3() {
        return stepBuilderFactory.get("printNextStep3")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Step3");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
