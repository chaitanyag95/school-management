package com.chaitanya.schoolmanagement.batch;


import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.service.student.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import java.util.List;

public class Listener extends JobExecutionListenerSupport {
    private static final Logger log = LoggerFactory.getLogger(Listener.class);

    private final StudentService studentService;

    public Listener(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("*******  Finish Job! Check the results **********");

            List<Student> students = studentService.findAll();

            for (Student student : students) {
                log.info("Found <" + student.getFullName() + "> in the database.");
            }
        }
    }
}
