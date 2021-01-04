package com.chaitanya.schoolmanagement.loader;

import com.chaitanya.schoolmanagement.model.admin.Admin;
import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.service.admin.AdminService;
import com.chaitanya.schoolmanagement.service.course.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class DatabaseLoader implements CommandLineRunner {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    Job job;

    @Override
    public void run(String... strings) throws Exception {
        log.info("*************** running database loader ***********************");
        createCourse();
        createAdmin();
        load();
    }

    private void createCourse() {
        log.info("*************** creating course from database loader ***********************");
        if (!courseService.courseExistByName("MCA")) {
            Course course = new Course();
            course.setName("MCA");
            courseService.save(course);
        }
        if (!courseService.courseExistByName("MBA")) {
            Course course = new Course();
            course.setName("MBA");
            courseService.save(course);
        }
        if (!courseService.courseExistByName("M-TECH")) {
            Course course = new Course();
            course.setName("M-TECH");
            courseService.save(course);
        }

    }

    public void createAdmin() {
        log.info("*************** creating admin from database loader ***********************");
        if (!adminService.isAdminExist("chaitanya@nexthoughts.com")) {
            Admin admin = new Admin();
            admin.setPassword(bCryptPasswordEncoder.encode("password"));
            admin.setEmail("chaitanya@nexthoughts.com");
            adminService.save(admin);
        }
    }

    public String load() throws Exception {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return "Done! Check Console Window for more details";
    }

    /*public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        log.info("*************** running load method og spring batch from database loader ***********************");
        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);
        System.out.println("JobExecution: " + jobExecution.getStatus());
        System.out.println("Batch is Running...");
        while (jobExecution.isRunning()) {
            System.out.println("...");
        }
        return jobExecution.getStatus();
    }*/

}
