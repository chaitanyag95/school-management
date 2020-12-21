package com.chaitanya.schoolmanagement.service.student;


import com.chaitanya.schoolmanagement.model.Student;
import com.chaitanya.schoolmanagement.util.annotation.TransactionalReadOnly;
import com.chaitanya.schoolmanagement.util.annotation.TransactionalWrite;

import java.util.List;

public interface StudentService {

    @TransactionalReadOnly
    List<Student> findAll();

    @TransactionalWrite
    void save(Student student);

}