package com.chaitanya.schoolmanagement.batch;

import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.model.student.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.util.Random;

public class Processor implements ItemProcessor<Student, Student> {

    private static final Logger log = LoggerFactory.getLogger(Processor.class);

    @Override
    public Student process(Student student) throws Exception {
        log.info(" ******* in processor *******");
        Random r = new Random();

        final String fullName = student.getFullName();
        final String email = student.getEmail();
        final String phoneNumber = student.getPhoneNumber();
        final String password = student.getPassword();
        final Course course = student.getCourse();

        final Student fixedStudent = new Student(fullName, email, course, phoneNumber, password);

        log.info("Converting (" + student + ") into (" + fixedStudent + ")");

        return fixedStudent;
    }
}
