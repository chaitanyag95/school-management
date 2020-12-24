package com.chaitanya.schoolmanagement.repository;

import com.chaitanya.schoolmanagement.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query
    Student findAllById(String id);

    Student findByEmail(String email);

}
