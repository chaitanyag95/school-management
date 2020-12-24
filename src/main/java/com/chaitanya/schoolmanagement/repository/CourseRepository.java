package com.chaitanya.schoolmanagement.repository;


import com.chaitanya.schoolmanagement.model.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String courseName);
}
