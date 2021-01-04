package com.chaitanya.schoolmanagement.config;

import com.chaitanya.schoolmanagement.batch.Listener;
import com.chaitanya.schoolmanagement.batch.Processor;
import com.chaitanya.schoolmanagement.batch.Reader;
import com.chaitanya.schoolmanagement.batch.Writer;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.service.student.StudentService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public StudentService studentService;

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).listener(new Listener(studentService))
				.flow(step1()).end().build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Student, Student>chunk(2)
				.reader(Reader.reader("students.csv"))
				.processor(new Processor()).writer(new Writer(studentService)).build();
	}


}
