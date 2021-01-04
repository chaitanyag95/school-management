package com.chaitanya.schoolmanagement.service.student;


import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.util.annotation.TransactionalReadOnly;
import com.chaitanya.schoolmanagement.util.annotation.TransactionalWrite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface StudentService {

    @TransactionalReadOnly
    List<Student> findAll();

    @TransactionalWrite
    void save(Student student);

    @TransactionalWrite
    void remove(Student student);

    @TransactionalWrite
    Student updateStudentDetails(Student student);

    @TransactionalReadOnly
    Student getStudentById(String studentId);

    @TransactionalReadOnly
    Student getStudentByEmail(String email);

    @TransactionalReadOnly
    Boolean isStudentExistByEmail(String email);

    @TransactionalWrite
    void saveStudentsByBatch(List<Student> students);

    @TransactionalReadOnly
    void downloadCsvFile() throws IOException;

    @TransactionalReadOnly
    void saveAsExcelFile() throws IOException;
}
