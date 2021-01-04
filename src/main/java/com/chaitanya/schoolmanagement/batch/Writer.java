package com.chaitanya.schoolmanagement.batch;


import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.service.student.StudentService;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class Writer implements ItemWriter<Student> {

    private final StudentService studentService;

    public Writer(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void write(List<? extends Student> students) throws Exception {
        studentService.saveStudentsByBatch((List<Student>) students);
    }

}
