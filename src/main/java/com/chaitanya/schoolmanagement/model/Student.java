package com.chaitanya.schoolmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    private String course;
    private String phoneNumber;

    public Student(String fullName, String email, String course, String phoneNumber) {
        this.fullName = fullName;
        this.email = email;
        this.course = course;
        this.phoneNumber = phoneNumber;
    }
}
