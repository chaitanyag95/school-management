package com.chaitanya.schoolmanagement.model.teacher;

import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.model.student.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Teacher {
    @Id
    private String id = UUID.randomUUID().toString();
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;
    private String createdById;

    public Teacher(String fullName, String email, Course course, String phoneNumber, String password) {
        this.fullName = fullName;
        this.email = email;
        this.course = course;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }


    public void setTeacher(Teacher teacher) {
        this.id = teacher.getId();
        this.fullName = teacher.getFullName();
        this.course = teacher.getCourse();
        this.email = teacher.getEmail();
        this.phoneNumber = teacher.getPhoneNumber();
    }
}
