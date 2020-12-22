package com.chaitanya.schoolmanagement.service.student;


import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
class StudentServiceImpl implements StudentService {

    public static final int NAME_INDEX = 0;
    public static final int EMAIL_INDEX = 1;
    public static final int COUNT_INDEX = 2;

    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void remove(Student student) {
        studentRepository.delete(student);
    }


}
