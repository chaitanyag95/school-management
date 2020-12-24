package com.chaitanya.schoolmanagement.service.teacher;


import com.chaitanya.schoolmanagement.model.teacher.Teacher;
import com.chaitanya.schoolmanagement.payload.TeacherLoginDto;
import com.chaitanya.schoolmanagement.util.annotation.TransactionalReadOnly;
import com.chaitanya.schoolmanagement.util.annotation.TransactionalWrite;

import java.util.List;

public interface TeacherService {

    @TransactionalReadOnly
    List<Teacher> findAll();

    @TransactionalWrite
    void save(Teacher teacher);

    @TransactionalWrite
    void remove(Teacher teacher);

    @TransactionalWrite
    Teacher updateTeacherDetails(Teacher teacher);

    @TransactionalReadOnly
    Teacher getTeacherById(String teacherId);

    @TransactionalReadOnly
    Boolean loginTeacher(TeacherLoginDto teacherLoginDto);

    @TransactionalReadOnly
    Teacher findTeacherByEmail(String email);


    boolean isTeacherExistByEmail(String email);
}
