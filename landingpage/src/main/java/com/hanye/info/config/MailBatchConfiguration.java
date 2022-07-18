package com.hanye.info.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hanye.info.batch.processor.MailItemProcessor;
import com.hanye.info.batch.reader.MailItemReader;
import com.hanye.info.batch.writer.MailItemWriter;


@Configuration
@EnableBatchProcessing
public class MailBatchConfiguration {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private MailItemReader mailItemReader;

	@Autowired
	private MailItemProcessor mailItemProcessor;

	@Autowired
	private MailItemWriter mailItemWriter;
	
	@Bean
	public Job sendMailJob() {
		return jobBuilderFactory.get("sendMailJob").incrementer(new RunIdIncrementer()).start(mailChunkStep())
				.build();
	}
	
	private Step mailChunkStep() {
		return stepBuilderFactory.get("mailChunkStep").<String, String>chunk(3)
				.reader(mailItemReader)
				.processor(mailItemProcessor)
				.writer(mailItemWriter)
				.build();
	}
	
}
