package com.chaitanya.schoolmanagement.model.student;

import com.chaitanya.schoolmanagement.model.course.Course;
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
public class Student {
    @Id
    private String id = UUID.randomUUID().toString();
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    public Student(String fullName, String email, Course course, String phoneNumber, String password) {
        this.fullName = fullName;
        this.email = email;
        this.course = course;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Student(String id, String fullName, String email, Course course, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.course = course;
        this.phoneNumber = phoneNumber;
    }


    public void setStudent(Student student) {
        this.id = student.getId();
        this.fullName = student.getFullName();
        this.course = student.getCourse();
        this.email = student.getEmail();
        this.phoneNumber = student.getPhoneNumber();
    }
}
