package com.chaitanya.schoolmanagement.service.course;


import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.util.annotation.TransactionalReadOnly;
import com.chaitanya.schoolmanagement.util.annotation.TransactionalWrite;

import java.util.List;

public interface CourseService {

    @TransactionalReadOnly
    List<Course> findAll();

    @TransactionalWrite
    void remove(Course course);

    @TransactionalWrite
    void save(Course course);

    @TransactionalReadOnly
    Boolean courseExistByName(String courseName);
}
