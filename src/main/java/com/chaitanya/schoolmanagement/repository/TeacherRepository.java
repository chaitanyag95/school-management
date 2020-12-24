package com.chaitanya.schoolmanagement.repository;

import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.model.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
    @Query
    Teacher findAllById(String id);

    Teacher findTeacherByEmail(String email);

}
