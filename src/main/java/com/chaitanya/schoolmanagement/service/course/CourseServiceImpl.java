package com.chaitanya.schoolmanagement.service.course;


import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public void remove(Course course) {
        courseRepository.delete(course);
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Boolean courseExistByName(String courseName) {
        Course course = courseRepository.findByName(courseName);
        if (course != null) {
            return true;
        }
        return false;
    }

    @Override
    public Course getCourseByName(String courseName) {
        Course course = courseRepository.findByName(courseName);
        return course;
    }
}
